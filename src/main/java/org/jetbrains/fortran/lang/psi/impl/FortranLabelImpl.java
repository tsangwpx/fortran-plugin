package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.*;

import org.jetbrains.fortran.lang.FortranTypes;
import org.jetbrains.fortran.lang.psi.*;

public class FortranLabelImpl extends FortranLabelRefImpl {
    public FortranLabelImpl(ASTNode node) {
        super(node);
    }
} /*extends FortranCompositeElementImpl implements FortranLabel ,
        PsiNameIdentifierOwner {

    public FortranLabelImpl(ASTNode node) {
        super(node);
    }

    @Override
    @NotNull
    public PsiElement getIntegerliteral() {
        return findNotNullChildByType(INTEGERLITERAL);
    }

    @Override
    public int gelLabelValue() {
        return parseInt(getText());
    }

    @Override
    public PsiElement setName(String newName) {
        ASTNode keyNode = getNode().findChildByType(FortranTypes.IDENTIFIER);
        if (keyNode != null) {
            FortranLabel newElement = FortranElementFactory.INSTANCE.createFortranLabel(getProject(), newName);
            ASTNode newKeyNode = newElement.getFirstChild().getNode();
            getNode().replaceChild(keyNode, newKeyNode);
        }
        return this;
    }

    @Override
    public PsiElement getNameIdentifier() {
        return getIntegerliteral();
    }
}*/