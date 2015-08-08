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
 * 1. Head
 * 2. Tail
 * 3. Destination
 */
public class PutList {

    public static Term execute(Process proc, Module m, Instruction i, List params) {
        Term arg1 = i.arg(0);
        Term arg2 = i.arg(1);
        Term arg3 = i.arg(2);

        if (arg1.isYRegister() && arg2.isXRegister() && arg3.isXRegister()) {
            Term head = proc.getY(arg1.toTuple().element(2).toInteger());
            Term tail = proc.getX(arg2.toTuple().element(2).toInteger());
            List list = new List(head, tail.toList());
            Integer r = arg3.toTuple().element(2).toInteger();
            proc.setX(r, list);
        } else if (arg1.isXRegister() && arg2.isXRegister() && arg3.isXRegister()) {
            Term head = proc.getX(arg1.toTuple().element(2).toInteger());
            Term tail = proc.getX(arg2.toTuple().element(2).toInteger());
            List list = new List(head, tail.toList());
            Integer r = arg3.toTuple().element(2).toInteger();
            proc.setX(r, list);
        } else if (arg1.isXRegister() && arg2.isList() && arg3.isXRegister()) {
            Term head = proc.getX(arg1.toTuple().element(2).toInteger());
            List tail = arg2.toList();
            List list = new List(head, tail);
            Integer r = arg3.toTuple().element(2).toInteger();
            proc.setX(r, list);
        } else {
            throw new Error("Unsupported: " + i);
        }
        return null;
    }

}
