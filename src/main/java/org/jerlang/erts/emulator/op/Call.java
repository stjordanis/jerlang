package org.jerlang.erts.emulator.op;

import org.jerlang.Module;
import org.jerlang.Process;
import org.jerlang.erts.emulator.Instruction;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * Call the function at Label.
 * Save the next instruction as the return address in the CP register.
 *
 * Arguments:
 * 1. Arity
 * 2. Label
 */
public class Call {

    public static Term execute(Process process, Module m, Instruction i, List params) {
        process.setCP(i.index() + 1);
        return i.arg(1);
    }

}
