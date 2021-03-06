package org.jerlang.erts.emulator.op;

import java.math.BigInteger;

import org.jerlang.Module;
import org.jerlang.Process;
import org.jerlang.erts.emulator.Instruction;
import org.jerlang.erts.erlang.Error;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * Calculate the number of bytes necessary to represent the Source in UTF16.
 *
 * Arguments:
 * 1. Label
 * 2. Source
 * 3. Destination
 *
 * Example:
 * {bs_utf16_size,{f,6},{x,0},{x,3}}
 */
public class BsUtf16Size {

    private static final BigInteger NEED2BYTES = new BigInteger("FFFF", 16);

    public static Term execute(Process proc, Module m, Instruction i, List params) {
        Integer source = i.arg(1).toArg(proc).toInteger();
        BigInteger codepoint = source.toBigInteger();
        Term destination = i.arg(2);
        if (!destination.isXRegister()) {
            throw new Error("Not implemented: " + i);
        }
        int bytes;
        if (codepoint.compareTo(NEED2BYTES) <= 0) {
            bytes = 2;
        } else {
            bytes = 4;
        }
        proc.setX(destination.toRegisterIndex(), Integer.of(bytes));
        return null;
    }

}
