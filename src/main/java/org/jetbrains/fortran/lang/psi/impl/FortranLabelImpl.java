package org.jetbrains.fortran.lang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.*;
import org.jetbrains.fortran.lang.psi.*;
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement;
import org.jetbrains.fortran.lang.resolve.ref.FortranLabelReferenceImpl;
import org.jetbrains.fortran.lang.resolve.ref.FortranReference;

public class FortranLabelImpl extends FortranCompositeElementImpl implements FortranLabel, FortranReferenceElement {

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
    @NotNull
    public PsiElement getReferenceNameElement() {
        return getIntegerliteral();
    }
    @Override
    @NotNull
    public String getReferenceName() {
        return getReferenceNameElement().getText();
    }

    @Override
    @NotNull
    public FortranReference getReference() {
        return new FortranLabelReferenceImpl(this);
    }

}