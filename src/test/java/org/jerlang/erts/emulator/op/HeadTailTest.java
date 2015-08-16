package org.jerlang.erts.emulator.op;

import static org.junit.Assert.assertEquals;

import org.jerlang.erts.Erlang;
import org.jerlang.exception.ThrowException;
import org.jerlang.type.Atom;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeadTailTest {

    @Before
    public void prepare() throws Exception {
        String[] cmd = { "cp", "src/test/resources/head_tail.beam", "." };
        Runtime.getRuntime().exec(cmd).waitFor();
    }

    @Test
    public void test_head() throws ThrowException {
        List params = List.of(List.of(Integer.of(1), Integer.of(2)));
        Integer expected = Integer.of(1);
        Term result = Erlang.apply(Atom.of("head_tail"), Atom.of("h"), params);
        assertEquals(expected, result);
    }

    @Test
    public void test_tail() throws ThrowException {
        List params = List.of(List.of(Integer.of(1), Integer.of(2)));
        List expected = List.of(Integer.of(2));
        Term result = Erlang.apply(Atom.of("head_tail"), Atom.of("t"), params);
        assertEquals(expected, result);
    }

    @After
    public void cleanup() throws Exception {
        String[] cmd = { "rm", "head_tail.beam" };
        Runtime.getRuntime().exec(cmd).waitFor();
    }

}
