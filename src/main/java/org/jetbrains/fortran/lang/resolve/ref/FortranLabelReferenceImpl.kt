package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtil
import org.jetbrains.fortran.lang.FortranTypes
import org.jetbrains.fortran.lang.psi.*
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement
import java.util.ArrayList

class FortranLabelReferenceImpl(element: FortranReferenceElement) :
        FortranReferenceBase<FortranReferenceElement>(element), FortranReference {

    override val FortranReferenceElement.referenceAnchor: PsiElement get() = referenceNameElement

    override fun getVariants(): Array<Any> {
        System.out.println("We are finding variants now")
        return emptyArray()
    }

   /* override fun resolve(): FortranCompositeElement? {
        // val project = myElement.project
        /// val properties = FortranUtil.findProperties(project, key)
//        Exception().printStackTrace(System.out)
        System.out.println("We are resolving now")
        return null
    }
*/
    override fun resolveInner(): List<FortranNamedElement>  {
       System.out.println("InnerResolve for label")
        var psiElement : PsiElement = element
       // find the root of the tree
       while (psiElement !is FortranFile) psiElement = psiElement.parent

       // find all labels in it
       val tmp =PsiTreeUtil.findChildrenOfType(psiElement, FortranLabel::class.java)
               .filter {(it.parent !is FortranGotoStmt && it.parent !is FortranLabelDoStmt)
                         && (element as FortranLabel).gelLabelValue() == (it as FortranLabel).gelLabelValue() }
               .toMutableList()

       return tmp
   }
    //   override fun getRangeInElement(): TextRange = element.referenceNameElement.textRange
}