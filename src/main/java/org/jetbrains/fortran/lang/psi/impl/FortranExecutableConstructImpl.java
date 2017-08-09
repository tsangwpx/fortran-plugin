// This is a generated file. Not intended for manual editing.
package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.stubs.IStubElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.fortran.lang.core.stubs.FortranExecutableConstructStub;
import org.jetbrains.fortran.lang.psi.FortranExecutableConstruct;
import org.jetbrains.fortran.lang.psi.FortranVisitor;
import org.jetbrains.fortran.lang.psi.ext.FortranExecutableConstructImplMixin;

public class FortranExecutableConstructImpl extends FortranExecutableConstructImplMixin implements FortranExecutableConstruct {

  public FortranExecutableConstructImpl(ASTNode node) {
    super(node);
  }

  public FortranExecutableConstructImpl(FortranExecutableConstructStub stub, IStubElementType stubType) {
    super(stub, stubType);
  }

  public void accept(@NotNull FortranVisitor visitor) {
    visitor.visitExecutableConstruct(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FortranVisitor) accept((FortranVisitor)visitor);
    else super.accept(visitor);
  }

}
