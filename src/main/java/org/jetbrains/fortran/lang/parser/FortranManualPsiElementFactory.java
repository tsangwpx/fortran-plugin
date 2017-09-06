package org.jetbrains.fortran.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.fortran.lang.FortranTypes;
import org.jetbrains.fortran.lang.psi.impl.*;

import static org.jetbrains.fortran.lang.psi.LabelDoStmt.LABEL_DO_STMT;

//import static org.jetbrains.fortran.lang.parser.LabelDoStmtType.LABEL_DO_STMT;

public class FortranManualPsiElementFactory {
    public static PsiElement createElement(ASTNode node) {
        IElementType type = node.getElementType();
        if (type == FortranTypes.LABEL) {
            return new FortranLabelImpl(node);
        } else if (type == FortranTypes.LABEL_DECL) {
            return new FortranLabelDeclImpl(node);
        }else if (type == FortranTypes.LABELED_DO_CONSTRUCT) {
            return new FortranLabeledDoConstructImpl(node);
        } else if (type == LABEL_DO_STMT) {
            return new FortranLabelDoStmtImpl(node);
        }

        return null;
    }
}
