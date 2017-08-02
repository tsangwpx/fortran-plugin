package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.fortran.lang.psi.FortranLabel;
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement;
import org.jetbrains.fortran.lang.resolve.ref.FortranLabelReferenceImpl;
import org.jetbrains.fortran.lang.resolve.ref.FortranReference;

import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.INTEGERLITERAL;

public class FortranLabelRefImpl extends FortranCompositeElementImpl implements FortranLabel, FortranReferenceElement {

    public FortranLabelRefImpl(ASTNode node) {
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