package org.jetbrains.fortran.lang.psi.ext

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import org.jetbrains.fortran.lang.psi.FortranCompositeElement

interface FortranReferenceElement : FortranCompositeElement {
    val referenceNameElement: PsiElement

    val referenceName: String

    override fun getReference(): PsiReference
}