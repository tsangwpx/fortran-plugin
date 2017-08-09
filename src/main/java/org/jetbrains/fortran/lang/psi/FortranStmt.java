package org.jetbrains.fortran.lang.psi;

import com.intellij.psi.StubBasedPsiElement;
import org.jetbrains.fortran.lang.core.stubs.FortranStatementStub;

public interface FortranStmt extends FortranCompositeElement, StubBasedPsiElement<FortranStatementStub> {
}