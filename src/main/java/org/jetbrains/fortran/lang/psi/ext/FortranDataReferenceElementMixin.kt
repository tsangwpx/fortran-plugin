package org.jetbrains.fortran.lang.psi.ext

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import org.jetbrains.fortran.FortranIcons
import org.jetbrains.fortran.lang.FortranTypes
import org.jetbrains.fortran.lang.FortranTypes.IDENTIFIER
import org.jetbrains.fortran.lang.core.stubs.FortranDataReferenceStub
import org.jetbrains.fortran.lang.psi.FortranDataReferenceElement
import org.jetbrains.fortran.lang.psi.FortranElementFactory
import org.jetbrains.fortran.lang.resolve.ref.FortranDataReferenceImpl
import javax.swing.Icon

abstract class FortranDataReferenceElementMixin :
    FortranStubbedElementImpl<FortranDataReferenceStub>,
    FortranDataReferenceElement {

    constructor(node: ASTNode) : super(node)

    constructor(stub: FortranDataReferenceStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType) { System.out.println("Mixin from stub") }

    override val referenceNameElement = checkNotNull(identifier) {
        "Data reference must contain identifier: $this ${this.text} at ${this.containingFile.virtualFile.path}"
    }

    override val referenceName: String get() = stub?.referenceName ?: referenceNameElement.text

    override fun getReference() = FortranDataReferenceImpl(this)

  /*  fun getName(element: FortranDataReferenceElement): String? {
        println("GET NAME")
        val keyNode = element.node.findChildByType(FortranTypes.IDENTIFIER)
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.text
        } else {
            return null
        }
    }
*/
    override fun setName(newName: String): PsiElement {
        val keyNode = node.findChildByType(FortranTypes.IDENTIFIER)
        if (keyNode != null) {
            val newElement = FortranElementFactory.createFortranDataReferenceElement(project, newName)
            val newKeyNode = newElement.firstChild.node
            node.replaceChild(keyNode, newKeyNode)
        }
        return this
    }
/*
    fun getPresentation(element: FortranReferenceElement): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return element.referenceName
            }

            override fun getLocationString(): String? {
                return element.containingFile.name
            }

            override fun getIcon(unused: Boolean): Icon? {
                return FortranIcons.fileTypeIcon
            }
        }
    }*/
}

