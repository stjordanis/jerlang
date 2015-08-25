package org.jerlang.type.stack;

import org.jerlang.type.Binary;
import org.jerlang.type.Float;
import org.jerlang.type.Integer;
import org.jerlang.type.Term;

/**
 * See:
 * https://github.com/erlang/otp/blob/maint/erts/emulator/beam/erl_bits.h
 */
public class BinMatchState extends Term {

    private final Binary binary;
    private final int slots;
    private int offset = 0; // bit-offset

    public BinMatchState(Binary binary, int slots) {
        this.binary = binary;
        this.slots = slots;
    }

    public int tail() {
        return binary.bits() - offset;
    }

    public BinMatchState toBinMatchState() {
        return this;
    }

    @Override
    public String toString() {
        return "BinMatchState";
    }

    public Binary get_all_binary(int unit, int flag) {
        // TODO This assumes that unit = 1 and flag = 0
        Binary result = binary.get_rest(offset);
        offset = binary.bits();
        return result;
    }

    public Float get_float(int size, int unit, int flag) {
        // TODO: This assumes size = 64, unit = 1 and flag = 0.
        Integer integer = get_integer(size, unit, flag);
        return new Float(Double.longBitsToDouble(integer.toLong()));
    }

    public Integer get_integer(int size, int unit, int flag) {
        // TODO: This assumes that unit is 1 and flag is 0.
        Integer result = new Integer(binary.extract_bits(offset, size));
        offset += size;
        return result;
    }

}