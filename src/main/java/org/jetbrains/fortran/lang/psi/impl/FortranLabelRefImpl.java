package org.jetbrains.fortran.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.fortran.lang.FortranTypes;
import org.jetbrains.fortran.lang.psi.FortranDataReferenceElement;
import org.jetbrains.fortran.lang.psi.FortranElementFactory;
import org.jetbrains.fortran.lang.psi.FortranLabel;
import org.jetbrains.fortran.lang.psi.ext.FortranReferenceElement;
import org.jetbrains.fortran.lang.resolve.ref.FortranLabelReferenceImpl;
import org.jetbrains.fortran.lang.resolve.ref.FortranReference;

import javax.swing.*;

import static java.lang.Integer.parseInt;
import static org.jetbrains.fortran.lang.FortranTypes.INTEGERLITERAL;

public class FortranLabelRefImpl extends FortranCompositeElementImpl implements FortranLabel, FortranReferenceElement,
        PsiNameIdentifierOwner {

    public FortranLabelRefImpl(ASTNode node) {
        super(node);
    }

    @Override
    @NotNull
    public PsiElement getIntegerliteral() {
        return findNotNullChildByType(INTEGERLITERAL);
    }

    @Override
    public int gelLabelValue() {
        return parseInt(getText());
    }

    @Override
    @NotNull
    public PsiElement getReferenceNameElement() {
        return getIntegerliteral();
    }
    @Override
    @NotNull
    public String getReferenceName() {
        return getReferenceNameElement().getText();
    }

    @Override
    @NotNull
    public FortranReference getReference() {
        return new FortranLabelReferenceImpl(this);
    }

    @Override
    public PsiElement setName(String newName) {
        ASTNode keyNode = getNode().findChildByType(FortranTypes.INTEGERLITERAL);
        if (keyNode != null) {
            FortranLabel newElement = FortranElementFactory.INSTANCE.createFortranLabel(getProject(), newName);
            ASTNode newKeyNode = newElement.getFirstChild().getNode();
            getNode().replaceChild(keyNode, newKeyNode);
        }
        return this;
    }

    @Override
    public PsiElement getNameIdentifier() {
        return getIntegerliteral();
    }

  /*  public ItemPresentation getPresentation() {return new ItemPresentation() {
        @Nullable
        @Override
        public String getPresentableText() {
            return getIntegerliteral().getText();
        }

        @Nullable
        @Override
        public String getLocationString() {
            PsiFile containingFile = getContainingFile();
            return containingFile == null ? null : containingFile.getName();
        }

        @Nullable
        @Override
        public Icon getIcon(boolean unused) {
            return null;
        }
//    };}*/
}