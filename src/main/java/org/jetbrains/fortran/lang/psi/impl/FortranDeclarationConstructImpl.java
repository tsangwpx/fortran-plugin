// This is a generated file. Not intended for manual editing.
package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.stubs.IStubElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.fortran.lang.core.stubs.FortranDeclarationConstructStub;
import org.jetbrains.fortran.lang.psi.FortranDeclarationConstruct;
import org.jetbrains.fortran.lang.psi.FortranVisitor;
import org.jetbrains.fortran.lang.psi.ext.FortranDeclarationConstructImplMixin;

public class FortranDeclarationConstructImpl extends FortranDeclarationConstructImplMixin implements FortranDeclarationConstruct {

  public FortranDeclarationConstructImpl(ASTNode node) {
    super(node);
  }

  public FortranDeclarationConstructImpl(FortranDeclarationConstructStub stub, IStubElementType stubType) {
    super(stub, stubType);
  }

  public void accept(@NotNull FortranVisitor visitor) {
    visitor.visitDeclarationConstruct(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FortranVisitor) accept((FortranVisitor)visitor);
    else super.accept(visitor);
  }

}
