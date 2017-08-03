package org.jetbrains.fortran.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement;
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement;

public interface FortranNumericalLabel extends FortranReferenceElement {

    @NotNull
    PsiElement getIntegerliteral();

    int gelLabelValue();
}
