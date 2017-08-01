package org.jetbrains.fortran.lang.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.*
import org.jetbrains.fortran.FortranFileType


object FortranElementFactory {
    fun createFortranDataReferenceElement(project: Project, name: String, value: String): FortranDataReferenceElement {
        val file = createFile(project, name + " = " + value)
        return file.getFirstChild() as FortranDataReferenceElement
    }

    fun createFortranDataReferenceElement(project: Project, name: String): FortranDataReferenceElement {
        val file = createFile(project, name)
        return file.getFirstChild() as FortranDataReferenceElement
    }

    fun createFile(project: Project, text: String): FortranFile {
        val name = "dummy.simple"
        return PsiFileFactory.getInstance(project).createFileFromText(name, FortranFileType, text) as FortranFile
    }
}