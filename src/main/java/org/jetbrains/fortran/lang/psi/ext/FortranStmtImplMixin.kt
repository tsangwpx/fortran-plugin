package org.jetbrains.fortran.lang.psi.ext

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import org.jetbrains.fortran.lang.core.stubs.FortranStatementStub
import org.jetbrains.fortran.lang.psi.FortranStmt

abstract class FortranStmtImplMixin : FortranStubbedElementImpl<FortranStatementStub>, FortranStmt {
    constructor(node: ASTNode) : super(node)

    constructor(stub: FortranStatementStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
}