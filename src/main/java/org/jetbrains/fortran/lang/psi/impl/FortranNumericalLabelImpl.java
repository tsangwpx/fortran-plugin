package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.fortran.lang.psi.FortranNumericalLabel;

import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.INTEGERLITERAL;

public class FortranNumericalLabelImpl extends FortranNumericalLabelImplMixin implements FortranNumericalLabel {

    public FortranNumericalLabelImpl(ASTNode node) {
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
}