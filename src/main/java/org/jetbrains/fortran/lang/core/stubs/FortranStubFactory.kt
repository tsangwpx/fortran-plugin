package org.jetbrains.fortran.lang.core.stubs

fun fortranStubFactory(name: String): FortranStubElementType<*, *> = when (name) {
    "PROGRAM_UNIT", "MAIN_PROGRAM", "MODULE" -> FortranProgramUnitStub.Type

    else -> error("Unknown element $name")
}

