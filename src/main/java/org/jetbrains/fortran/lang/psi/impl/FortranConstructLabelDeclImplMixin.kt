package org.jetbrains.fortran.lang.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.jetbrains.fortran.lang.psi.FortranConstructLabelDecl
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElementImpl
import org.jetbrains.fortran.lang.FortranTypes.IDENTIFIER

abstract class FortranConstructLabelDeclImplMixin(node : ASTNode) : FortranNamedElementImpl(node), FortranConstructLabelDecl {
    override fun getNameIdentifier(): PsiElement = notNullChild(findChildByType(IDENTIFIER))

    override fun setName(name: String): PsiElement? {
        return this
    }

    fun gelLabelValue() = nameIdentifier.text
}