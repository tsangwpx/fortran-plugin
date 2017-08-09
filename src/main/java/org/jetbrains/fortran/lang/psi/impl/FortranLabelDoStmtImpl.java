package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.fortran.lang.core.stubs.FortranStatementStub;
import org.jetbrains.fortran.lang.psi.*;

import static org.jetbrains.fortran.lang.FortranTypes.COLON;
import static org.jetbrains.fortran.lang.FortranTypes.EOL;

public class FortranLabelDoStmtImpl extends FortranStmtImpl implements FortranLabelDoStmt {

    public FortranLabelDoStmtImpl(ASTNode node) {
        super(node);
    }

    public FortranLabelDoStmtImpl(FortranStatementStub stub, IStubElementType stubType) {
        super(stub, stubType);
    }

    @Override
    @NotNull
    public FortranLabel getNumericalLabel() { return findNotNullChildByClass(FortranLabel.class); }

    @Override
    @Nullable
    public FortranLabelDecl getNumericalLabelDecl() { return findNotNullChildByClass(FortranLabelDecl.class); }

    @Override
    @Nullable
    public FortranExpr getExpr() {
        return findChildByClass(FortranExpr.class);
    }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(COLON);
    }


    @Override
    @Nullable
    public PsiElement getEol() {
        return findChildByType(EOL);
    }

}