package org.jerlang.type;

/**
 * A piece of data of any data type is called a term.
 *
 * http://www.erlang.org/doc/reference_manual/data_types.html
 */
public class Term {

    public static Term of(String string) {
        if (string == null) {
            return List.nil;
        }

        if (string.isEmpty()) {
            return List.nil;
        }

        return new Str(string);
    }

    public boolean isFalse() {
        throw new Error("Cannot convert to boolean: " + this);
    }

    public boolean isTrue() {
        throw new Error("Cannot convert to boolean: " + this);
    }

    public Atom toAtom() {
        throw new Error("Cannot convert to atom: " + this);
    }

    public Binary toBinary() {
        throw new Error("Cannot convert to binary: " + this);
    }

    public Fun toFun() {
        throw new Error("Cannot convert to fun: " + this);
    }

    public Integer toInteger() {
        throw new Error("Cannot convert to integer: " + this);
    }

    public List toList() {
        throw new Error("Cannot convert to list: " + this);
    }

    public Map toMap() {
        throw new Error("Cannot convert to map: " + this);
    }

    public PID toPID() {
        throw new Error("Cannot convert to pid: " + this);
    }

    public Str toStr() {
        throw new Error("Cannot convert to str: " + this);
    }

    public Tuple toTuple() {
        throw new Error("Cannot convert to tuple: " + this);
    }

}
