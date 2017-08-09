package org.jetbrains.fortran.lang.core.stubs

import com.intellij.psi.stubs.*
import org.jetbrains.fortran.lang.psi.FortranExecutableConstruct

class FortranExecutableConstructStub(
        parent: StubElement<*>?, elementType: IStubElementType<*, *>
): StubBase<FortranExecutableConstruct>(parent, elementType) {

    class Type<PsiT : FortranExecutableConstruct>(
            debugName: String,
            private val psiCtor: (FortranExecutableConstructStub, IStubElementType<*, *>) -> PsiT
    ) : FortranStubElementType<FortranExecutableConstructStub, FortranExecutableConstruct>(debugName) {

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): FortranExecutableConstructStub =
                FortranExecutableConstructStub(parentStub, this)

        override fun serialize(stub: FortranExecutableConstructStub, dataStream: StubOutputStream) {}

        override fun createPsi(stub: FortranExecutableConstructStub) = psiCtor(stub, this)

        override fun createStub(psi: FortranExecutableConstruct, parentStub: StubElement<*>?) =
                FortranExecutableConstructStub(parentStub, this)

        override fun indexStub(stub: FortranExecutableConstructStub, sink: IndexSink) {
            // NOP
        }
    }
}