package org.jetbrains.fortran.lang.psi.ext

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import org.jetbrains.fortran.lang.core.stubs.FortranDeclarationConstructStub
import org.jetbrains.fortran.lang.psi.FortranDeclarationConstruct

abstract class FortranDeclarationConstructImplMixin : FortranStubbedElementImpl<FortranDeclarationConstructStub>, FortranDeclarationConstruct {
    constructor(node: ASTNode) : super(node)

    constructor(stub: FortranDeclarationConstructStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
}