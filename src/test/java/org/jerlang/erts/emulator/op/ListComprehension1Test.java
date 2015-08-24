package org.jerlang.erts.emulator.op;

import static org.junit.Assert.assertEquals;

import org.jerlang.erts.Erlang;
import org.jerlang.exception.ThrowException;
import org.jerlang.type.Atom;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Term;
import org.junit.Test;

public class ListComprehension1Test extends AbstractOpTest {

    public ListComprehension1Test() {
        super("example5.beam");
    }

    @Test
    public void test_list_comprehension() throws ThrowException {
        List expected = List.of(Integer.of(2), Integer.of(4), Integer.of(6));
        List params = List.nil;
        Term result = Erlang.apply(Atom.of("example5"), Atom.of("test"), params);
        assertEquals(expected, result);
    }

}
