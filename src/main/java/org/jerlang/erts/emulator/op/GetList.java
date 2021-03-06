package org.jerlang.erts.emulator.op;

import org.jerlang.Module;
import org.jerlang.Process;
import org.jerlang.erts.emulator.Instruction;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * Get the head and tail (or car and cdr) parts of a list
 * (a cons cell) from Source and put them into the registers
 * Head and Tail.
 *
 * Arguments:
 * 1. Source
 * 2. Head
 * 3. Tail
 */
public class GetList {

    public static Term execute(Process proc, Module m, Instruction i, List params) {
        Integer sourceReg = i.arg(0).toTuple().element(2).toInteger();
        List list = proc.getX(sourceReg).toList();
        Integer headReg = i.arg(1).toTuple().element(2).toInteger();
        Integer tailReg = i.arg(2).toTuple().element(2).toInteger();
        proc.setX(headReg, list.head());
        proc.setX(tailReg, list.tail());
        return null;
    }

}
