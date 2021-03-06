package org.jerlang.erts.emulator.op;

import org.jerlang.Module;
import org.jerlang.Process;
import org.jerlang.erts.emulator.Instruction;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * Allocate space for StackNeed words on the stack. If a GC is needed
 * during allocation there are Live number of live X registers.
 * Also save the continuation pointer (CP) on the stack.
 */
public class Allocate {

    public static Term execute(Process proc, Module m, Instruction i, List params) {
        Integer need = i.arg(0).toInteger();
        Integer keep = i.arg(1).toInteger();

        if (need.toInt() > 0) {
            proc.allocate(need.toInt(), keep.toInt());
        }

        proc.storeCP();

        return null;
    }

}
