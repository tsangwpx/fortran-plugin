package org.jetbrains.fortran.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.fortran.lang.core.stubs.FortranStubFactoryKt;

public interface LabelDo {
    IElementType LABEL_DO_STMT = FortranStubFactoryKt.fortranStubFactory("LABEL_DO_STMT");

   // IElementType LABELED_DO_CONSTRUCT = new FortranTokenType("LABELED_DO_CONSTRUCT");
    IElementType LABELED_DO_CONSTRUCT = FortranStubFactoryKt.fortranStubFactory("LABELED_DO_CONSTRUCT");
}
