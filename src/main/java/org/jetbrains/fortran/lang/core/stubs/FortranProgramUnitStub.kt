package org.jetbrains.fortran.lang.core.stubs

import com.intellij.psi.stubs.*
import org.jetbrains.fortran.lang.psi.FortranProgramUnit

class FortranProgramUnitStub(
        parent: StubElement<*>?, elementType: IStubElementType<*, *>
): StubBase<FortranProgramUnit>(parent, elementType) {

    class Type<PsiT : FortranProgramUnit>(
            debugName: String,
            private val psiCtor: (FortranProgramUnitStub, IStubElementType<*, *>) -> PsiT
    ) : FortranStubElementType<FortranProgramUnitStub, FortranProgramUnit>(debugName) {

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): FortranProgramUnitStub =
                FortranProgramUnitStub(parentStub, this)

        override fun serialize(stub: FortranProgramUnitStub, dataStream: StubOutputStream) {}

        override fun createPsi(stub: FortranProgramUnitStub) = psiCtor(stub, this)

        override fun createStub(psi: FortranProgramUnit, parentStub: StubElement<*>?) =
                FortranProgramUnitStub(parentStub, this)

        override fun indexStub(stub: FortranProgramUnitStub, sink: IndexSink) {
            // NOP
        }
    }
}