package org.jetbrains.fortran.lang.psi.ext

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import org.jetbrains.fortran.lang.core.stubs.FortranExecutableConstructStub
import org.jetbrains.fortran.lang.psi.FortranExecutableConstruct

abstract class FortranExecutableConstructImplMixin : FortranStubbedElementImpl<FortranExecutableConstructStub>, FortranExecutableConstruct {
    constructor(node: ASTNode) : super(node)

    constructor(stub: FortranExecutableConstructStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
}