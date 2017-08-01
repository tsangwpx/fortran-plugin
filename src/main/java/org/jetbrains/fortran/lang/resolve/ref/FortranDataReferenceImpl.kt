package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.jetbrains.fortran.lang.psi.FortranCompositeElement
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement
import java.util.ArrayList


class FortranDataReferenceImpl(element: FortranReferenceElement) :
    FortranReferenceBase<FortranReferenceElement>(element), FortranReference {

    override val FortranReferenceElement.referenceAnchor: PsiElement get() = referenceNameElement

    override fun getVariants(): Array<Any> {
        System.out.println("We are finding variants now")
        return emptyArray()
    }

    override fun resolve(): FortranCompositeElement? {
       // val project = myElement.project
       /// val properties = FortranUtil.findProperties(project, key)
//        Exception().printStackTrace(System.out)
        System.out.println("We are resolving now")
        return null
    }

    override fun resolveInner(): List<FortranNamedElement> = ArrayList<FortranNamedElement>()
 //   override fun getRangeInElement(): TextRange = element.referenceNameElement.textRange
}
