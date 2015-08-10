package org.jerlang.erts.emulator.op;

import static org.junit.Assert.assertEquals;

import org.jerlang.erts.Erlang;
import org.jerlang.type.Atom;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListComprehension2Test {

    @Before
    public void prepare() throws Exception {
        String[] cmd = { "cp", "src/test/resources/example6.beam", "." };
        Runtime.getRuntime().exec(cmd).waitFor();
    }

    @Test
    public void test_list_comprehension() {
        List expected = List.of(Integer.of(2));
        List params = List.nil;
        Term result = Erlang.apply(Atom.of("example6"), Atom.of("test"), params);
        assertEquals(expected, result);
    }

    @After
    public void cleanup() throws Exception {
        String[] cmd = { "rm", "example6.beam" };
        Runtime.getRuntime().exec(cmd).waitFor();
    }

}