package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import org.jetbrains.fortran.lang.lexer.FortranLexer
import org.jetbrains.fortran.lang.psi.FortranNumericalLabel
import org.jetbrains.fortran.lang.psi.FortranTokenType

class FortranFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(FortranLexer(false),
                FortranTokenType.WORD_OR_ILITERAL
                , FortranTokenType.COMMENTS, TokenSet.EMPTY)
    }
    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is FortranNumericalLabel
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        if (element is FortranNumericalLabel) {
            return "fortran label"
        } else {
            return ""
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        if (element is FortranNumericalLabel) {
            return element.text
        } else {
            return ""
        }
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        if (element is FortranNumericalLabel) {
            return element.text
        } else {
            return ""
        }
    }
}