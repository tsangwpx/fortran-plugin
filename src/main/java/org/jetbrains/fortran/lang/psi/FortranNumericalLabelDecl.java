package org.jetbrains.fortran.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement;

public interface FortranNumericalLabelDecl extends FortranNamedElement {

    @NotNull
    PsiElement getIntegerliteral();

    int gelLabelValue();
}
