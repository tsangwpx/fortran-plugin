package org.jetbrains.fortran.lang.psi.ext

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import org.jetbrains.fortran.lang.core.stubs.FortranProgramUnitStub
import org.jetbrains.fortran.lang.psi.FortranProgramUnit

abstract class FortranProgramUnitImplMixin : FortranStubbedElementImpl<FortranProgramUnitStub>, FortranProgramUnit {
    constructor(node: ASTNode) : super(node)

    constructor(stub: FortranProgramUnitStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
}