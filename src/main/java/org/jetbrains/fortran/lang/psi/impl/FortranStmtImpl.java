package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import org.jetbrains.fortran.lang.core.stubs.FortranStatementStub;
import org.jetbrains.fortran.lang.psi.FortranStmt;
import org.jetbrains.fortran.lang.psi.ext.FortranStmtImplMixin;

public class FortranStmtImpl extends FortranStmtImplMixin implements FortranStmt {
    public FortranStmtImpl(ASTNode node) {
        super(node);
    }

    public FortranStmtImpl(FortranStatementStub stub, IStubElementType stubType) {
        super(stub, stubType);
    }
}

