package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.fortran.lang.psi.*
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement
import org.jetbrains.fortran.lang.psi.impl.FortranLabelImpl


class FortranLabelReferenceImpl(element: FortranReferenceElement) :
        FortranReferenceBase<FortranReferenceElement>(element), FortranReference {

    override val FortranReferenceElement.referenceAnchor: PsiElement get() = referenceNameElement

    override fun getVariants(): Array<Any> {
        System.out.println("We are finding variants now")
        return emptyArray()
    }

    override fun resolveInner(): List<FortranNamedElement>  {
        var psiElement : PsiElement = element
       // find the root of the tree
       while (psiElement !is FortranFile) psiElement = psiElement.parent

       // find all labels in it
       val tmp =PsiTreeUtil.findChildrenOfType(psiElement, FortranLabelImpl::class.java)
               .filter {(element as FortranLabel).gelLabelValue() == (it as FortranLabel).gelLabelValue() }
               .toMutableList()
       return tmp
   }
}