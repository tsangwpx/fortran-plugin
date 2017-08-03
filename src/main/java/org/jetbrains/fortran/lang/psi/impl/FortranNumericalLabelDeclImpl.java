package org.jetbrains.fortran.lang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.*;
import org.jetbrains.fortran.lang.psi.*;

public class FortranNumericalLabelDeclImpl extends FortranNumericalLabelDeclImplMixin implements FortranNumericalLabelDecl {
    public FortranNumericalLabelDeclImpl(ASTNode node) {
        super(node);
    }

    @Override
    public int gelLabelValue() {
        return parseInt(getText());
    }

    @Override
    @NotNull
    public PsiElement getIntegerliteral() {
        return findNotNullChildByType(INTEGERLITERAL);
    }
}