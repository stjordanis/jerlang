package org.jerlang.erts.emulator.op;

import org.jerlang.Module;
import org.jerlang.Process;
import org.jerlang.erts.emulator.Instruction;
import org.jerlang.type.BinMatchState;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * Bitsyntax
 *
 * Extracts an integer value from a binary.
 * Uses the BinMatchState object to store current offset.
 *
 * Example:
 * {bs_get_integer2,{f,3},{x,1},2,4,1,0,{x,2}}
 *
 * Arg1: Fail
 * Arg2: BinMatchState
 * Arg3: Live
 * Arg4: Size
 * Arg5: Unit
 * Arg6: Flags
 * Arg7: Destination
 */
public class BsGetInteger2 {

    public static Term execute(Process proc, Module m, Instruction i, List params) {
        BinMatchState bms;
        Term arg2 = i.arg(1);

        if (arg2.isXRegister()) {
            bms = proc.getX(arg2.toTuple().element(2).toInteger()).toBinMatchState();
        } else {
            throw new Error("Unsupported arg2: " + i);
        }

        int size = i.arg(3).toInteger().toInt();
        int unit = i.arg(4).toInteger().toInt();
        int flag = i.arg(5).toInteger().toInt();

        Integer result = bms.get_integer(size, unit, flag);

        Term destination = i.arg(6);
        if (destination.isXRegister()) {
            proc.setX(destination.toTuple().element(2).toInteger(), result);
            return null;
        } else {
            throw new Error("Unsupported destination: " + i);
        }
    }

}
