package org.jetbrains.fortran.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.fortran.lang.core.stubs.FortranStubFactoryKt;

public interface LabelDoStmt {
    IElementType LABEL_DO_STMT = FortranStubFactoryKt.fortranStubFactory("LABEL_DO_STMT");

}
