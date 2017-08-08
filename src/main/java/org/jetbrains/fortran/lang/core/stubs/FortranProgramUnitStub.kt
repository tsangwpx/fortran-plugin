package org.jetbrains.fortran.lang.core.stubs

import com.intellij.psi.stubs.*
import org.jetbrains.fortran.lang.psi.FortranProgramUnit
import org.jetbrains.fortran.lang.psi.impl.FortranProgramUnitImpl

class FortranProgramUnitStub(
        parent: StubElement<*>?, elementType: IStubElementType<*, *>,
        override val name: String?
): StubBase<FortranProgramUnit>(parent, elementType), FortranNamedStub {
    object Type : FortranStubElementType<FortranProgramUnitStub, FortranProgramUnit>("Program unit") {
        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): FortranProgramUnitStub =
                FortranProgramUnitStub(parentStub, this,
                        dataStream.readName()?.string
                )

        override fun serialize(stub: FortranProgramUnitStub, dataStream: StubOutputStream) =
                with(dataStream) {
                    writeName(stub.name)
                }

        override fun createPsi(stub: FortranProgramUnitStub) =
                FortranProgramUnitImpl(stub, this)

        override fun createStub(psi: FortranProgramUnit, parentStub: StubElement<*>?) =
                FortranProgramUnitStub(parentStub, this, "AAAAA")


        override fun indexStub(stub: FortranProgramUnitStub, sink: IndexSink) {
            // NOP
        }
    }
}