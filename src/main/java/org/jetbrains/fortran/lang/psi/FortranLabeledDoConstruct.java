package org.jetbrains.fortran.lang.psi;

import java.util.List;

import com.intellij.psi.StubBasedPsiElement;
import org.jetbrains.annotations.*;
import org.jetbrains.fortran.lang.core.stubs.FortranExecutableConstructStub;

public interface FortranLabeledDoConstruct extends FortranExecutableConstruct, StubBasedPsiElement<FortranExecutableConstructStub> {

    @NotNull
    List<FortranExpr> getExprList();

    @NotNull
    FortranLabelDoStmt getLabelDoStmt ();

    @Nullable
    FortranStmt getDoTermActionStmt();

    @Nullable
    FortranLabeledDoConstruct getLabeledDoTermConstract();

    @Nullable
    FortranEndDoStmt getEndDoStmt();
}
