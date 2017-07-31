package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.openapi.util.TextRange
import org.jetbrains.fortran.lang.psi.FortranCompositeElement
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement


class FortranDataReferenceImpl(element: FortranReferenceElement) :
    FortranReferenceBase<FortranReferenceElement>(element) {

    override fun getVariants(): Array<Any> {
        return emptyArray()
    }

    override fun resolve(): FortranCompositeElement? {
       // val project = myElement.project
       /// val properties = FortranUtil.findProperties(project, key)
System.out.println("We are resolving now")
        return null
    }

    override fun getRangeInElement(): TextRange = element.referenceNameElement.textRange
}
