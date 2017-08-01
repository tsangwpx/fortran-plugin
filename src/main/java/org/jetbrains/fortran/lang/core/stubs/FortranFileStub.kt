package org.jetbrains.fortran.lang.core.stubs

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.StubBuilder
import com.intellij.psi.stubs.*
import com.intellij.psi.tree.IStubFileElementType
import com.intellij.util.containers.ContainerUtil
import org.jetbrains.fortran.FortranLanguage
import org.jetbrains.fortran.lang.psi.FortranFile

class FortranFileStub(file: FortranFile?) : PsiFileStubImpl<FortranFile>(file) {
    init {
        System.out.println("FortranFileStub")
    }
    override fun getType() = Type

    object Type : IStubFileElementType<FortranFileStub>(FortranLanguage) {
        // Bump this number if Stub structure changes
        override fun getStubVersion(): Int = 1

        override fun getBuilder(): StubBuilder = object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> = FortranFileStub(file as FortranFile)
        }

        override fun serialize(stub: FortranFileStub, dataStream: StubOutputStream) {
           // dataStream.writeName(stub.getName)
        }

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): FortranFileStub {
           // val ref = dataStream.readName()
            return FortranFileStub(null)
        }

        override fun getExternalId(): String = "Fortran.file"

        private val PARESED = ContainerUtil.newConcurrentSet<String>()
        override fun doParseContents(chameleon: ASTNode, psi: PsiElement): ASTNode? {
            val path = psi.containingFile?.virtualFile?.path
            if (path != null && PARESED.add(path)) {
                println("Parsing (${PARESED.size}) ${path}")
            //    Exception().printStackTrace(System.out)
                println()
            }
            return super.doParseContents(chameleon, psi)
        }
    }
}