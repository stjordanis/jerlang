package org.jerlang.erts.erlang;

import org.jerlang.erts.Erlang;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;

/**
 * abs(Float) -> float()
 * abs(Int) -> integer() >= 0
 *
 * Types:
 * Float = float()
 * Int = integer()
 *
 * Returns an integer or float which is the arithmetical absolute
 * value of Float or Int.
 *
 * > abs(-3.33).
 * 3.33
 * > abs(-3).
 * 3
 *
 * Allowed in guard tests.
 */
public class ErlangAbs {

    public static Term dispatch(List params) {
        switch (Erlang.length_1(params).toInt()) {
        case 1:
            return abs_1(params.head().toInteger());
        default:
            throw new Error("badarg");
        }
    }

    private static Integer abs_1(Integer integer) {
        return new Integer(integer.toBigInteger().abs());
    }

}