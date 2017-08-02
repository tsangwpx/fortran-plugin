package org.jetbrains.fortran.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement;
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement;

public interface FortranLabel  extends FortranReferenceElement, FortranNamedElement {

    @NotNull
    PsiElement getIntegerliteral();

    int gelLabelValue();
}
