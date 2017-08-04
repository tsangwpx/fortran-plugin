package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ObjectUtils
import com.intellij.util.ProcessingContext
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement
import com.intellij.psi.PsiReference
import com.intellij.openapi.util.TextRange
import org.picocontainer.defaults.SimpleReference
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.psi.PsiReferenceContributor
import org.jetbrains.fortran.lang.FortranTypes
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement


class FortranReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(FortranTypes.IDENTIFIER), DataReferenceProvider())
    }

    private abstract class ReferenceProvider : PsiReferenceProvider() {
        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val atom = ObjectUtils.tryCast(element, FortranReferenceElement::class.java)
            return if (atom != null)
                arrayOf(createReference(atom))
            else
                PsiReference.EMPTY_ARRAY
        }

        protected abstract fun createReference(atom: FortranReferenceElement): PsiReference
    }

    private class DataReferenceProvider : ReferenceProvider() {
        override fun createReference(atom: FortranReferenceElement): PsiReference {
            return FortranDataReferenceImpl(atom)
        }
    }
}