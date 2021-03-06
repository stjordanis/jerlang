package org.jerlang;

import static org.junit.Assert.assertEquals;

import org.jerlang.type.Atom;
import org.jerlang.type.Integer;
import org.junit.Test;

public class FunctionSignatureTest {

    @Test
    public void testEquals() {
        Atom mod = Atom.of("mod");
        Atom fun = Atom.of("fun");
        Integer arity = new Integer(0);
        FunctionSignature functionSignature1 = new FunctionSignature(mod, fun, arity);
        FunctionSignature functionSignature2 = new FunctionSignature(mod, fun, arity);
        assertEquals(functionSignature1, functionSignature2);
    }

    @Test
    public void testToString() {
        Atom mod = Atom.of("mod");
        Atom fun = Atom.of("fun");
        Integer arity = new Integer(0);
        FunctionSignature functionSignature = new FunctionSignature(mod, fun, arity);
        assertEquals("mod:fun/0", functionSignature.toString());
    }

}
