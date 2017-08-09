package org.jetbrains.fortran.lang.core.stubs

import com.intellij.psi.stubs.*
import org.jetbrains.fortran.lang.psi.FortranDeclarationConstruct

class FortranDeclarationConstructStub(
        parent: StubElement<*>?, elementType: IStubElementType<*, *>
): StubBase<FortranDeclarationConstruct>(parent, elementType) {

    class Type<PsiT : FortranDeclarationConstruct>(
            debugName: String,
            private val psiCtor: (FortranDeclarationConstructStub, IStubElementType<*, *>) -> PsiT
    ) : FortranStubElementType<FortranDeclarationConstructStub, FortranDeclarationConstruct>(debugName) {

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): FortranDeclarationConstructStub =
                FortranDeclarationConstructStub(parentStub, this)

        override fun serialize(stub: FortranDeclarationConstructStub, dataStream: StubOutputStream) {}

        override fun createPsi(stub: FortranDeclarationConstructStub) = psiCtor(stub, this)

        override fun createStub(psi: FortranDeclarationConstruct, parentStub: StubElement<*>?) =
                FortranDeclarationConstructStub(parentStub, this)

        override fun indexStub(stub: FortranDeclarationConstructStub, sink: IndexSink) {
            // NOP
        }
    }
}