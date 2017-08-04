package org.jetbrains.fortran.ide.refactoring

import com.intellij.lang.refactoring.NamesValidator
import com.intellij.openapi.project.Project

object FortranNamesValidator : NamesValidator {
    override fun isKeyword(name: String, project: Project): Boolean = true

    override fun isIdentifier(name: String, project: Project): Boolean = true
}