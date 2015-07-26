package org.jerlang.erts;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

import org.jerlang.FunctionSignature;
import org.jerlang.Module;
import org.jerlang.ModuleRegistry;
import org.jerlang.ProcessRegistry;
import org.jerlang.erts.erlang.ErlangAbs;
import org.jerlang.erts.erlang.ErlangApply;
import org.jerlang.erts.erlang.ErlangDisplay;
import org.jerlang.erts.erlang.Error;
import org.jerlang.erts.init.ProcessFlag;
import org.jerlang.type.Atom;
import org.jerlang.type.Binary;
import org.jerlang.type.Boolean;
import org.jerlang.type.Fun;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.Map;
import org.jerlang.type.Number;
import org.jerlang.type.PID;
import org.jerlang.type.Str;
import org.jerlang.type.Term;
import org.jerlang.type.Tuple;

/**
 * http://www.erlang.org/doc/man/erlang.html
 */
public class Erlang {

    public static final String[] EXPORT = {
        "abs/1",
        "apply/3",
        "display/1",
        "error/1",
        "error/2",
        "function_exported/3",
        "get/0",
        "get/1",
        "get_keys/0",
        "get_keys/1",
        "halt/0",
        "halt/1",
        "halt/2",
        "hd/1",
        "integer_to_binary/1",
        "integer_to_binary/2",
        "integer_to_list/1",
        "integer_to_list/2",
        "is_atom/1",
        "is_binary/1",
        "is_boolean/1",
        "is_function/1",
        "is_integer/1",
        "is_list/1",
        "is_map/1",
        "is_number/1",
        "is_pid/1",
        "is_tuple/1",
        "length/1"
    };

    public static Term abs(List params) {
        return ErlangAbs.dispatch(params);
    }

    public static Term apply(List params) {
        return ErlangApply.dispatch(params);
    }

    public static Term display(List params) {
        return ErlangDisplay.dispatch(params);
    }

    /**
     * Stops the execution of the calling process with the reason `reason`,
     * where `reason` is any term. The actual exit reason will be
     * `{reason, where}`, where `where` is a list of the functions most
     * recently called (the current function first). Since evaluating this
     * function causes the process to terminate, it has no return value.
     *
     * http://www.erlang.org/doc/man/erlang.html#error-1
     */
    public static void error(Term reason) {
        throw new Error(reason);
    }

    /**
     * Stops the execution of the calling process with the reason `reason`,
     * where `reason` is any term. The actual exit reason will be
     * `{reason, where}`, where `where` is a list of the functions most
     * recently called (the current function first). `args` is expected to
     * be the list of arguments for the current function; in Beam it will be
     * used to provide the actual arguments for the current function in the
     * `where` term. Since evaluating this function causes the process to
     * terminate, it has no return value.
     *
     * http://www.erlang.org/doc/man/erlang.html#error-2
     */
    public static void error(Term reason, List args) {
        throw new Error(reason, args);
    }

    /**
     * Returns true if the module Module is loaded and contains an exported
     * function Function/Arity, or if there is a BIF (a built-in function
     * implemented in C) with the given name; otherwise returns false.
     *
     * http://www.erlang.org/doc/man/erlang.html#function_exported-3
     */
    public static Term function_exported(List params) {
        switch (Erlang.length_1(params).toInt()) {
        case 3:
            Atom m = params.head().toAtom();
            params = params.tail();
            Atom f = params.head().toAtom();
            params = params.tail();
            Integer a = params.head().toInteger();
            return Boolean.of(function_exported_3(m, f, a));
        default:
            throw new Error("badarg");
        }
    }

    public static boolean function_exported_3(Atom module, Atom function, Integer arity) {
        Module m = ModuleRegistry.get(module);
        if (m == null) {
            return false;
        } else {
            return m.hasFunction(new FunctionSignature(module, function, arity));
        }
    }

    /**
     * Returns the process dictionary as a list of `{Key, Val}` tuples.
     *
     * http://www.erlang.org/doc/man/erlang.html#get-0
     */
    public static List get() {
        return Runtime.getProcess().dictionary().get();
    }

    /**
     * Returns the value Val associated with Key in the process dictionary,
     * or undefined if Key does not exist.
     *
     * http://www.erlang.org/doc/man/erlang.html#get-1
     */
    public static Term get(Term key) {
        return Runtime.getProcess().dictionary().get(key);
    }

    /**
     * Returns a list of keys all keys present in the process dictionary.
     *
     * http://www.erlang.org/doc/man/erlang.html#get_keys-0
     */
    public static List get_keys() {
        return Runtime.getProcess().dictionary().get_keys();
    }

    /**
     * Returns a list of keys which are associated with the value Val
     * in the process dictionary.
     *
     * http://www.erlang.org/doc/man/erlang.html#get_keys-1
     */
    public static List get_keys(Term value) {
        return Runtime.getProcess().dictionary().get_keys(value);
    }

    public static Term halt(List params) {
        switch (length_1(params).toInt()) {
        case 0:
            halt_0();
            return null;
        case 1:
            halt_1(params.head());
            return null;
        case 2:
            Term status = params.head();
            params = params.tail();
            List options = params.head().toList();
            halt_2(status, options);
            return null;
        default:
            throw new Error("badarg");
        }
    }

    /**
     * The same as `halt(0, [])`.
     */
    public static void halt_0() {
        halt_2(Integer.of(0), List.nil);
    }

    /**
     * The same as halt(Status, []).
     *
     * http://www.erlang.org/doc/man/erlang.html#halt-1
     */
    public static void halt_1(Term status) {
        halt_2(status, List.nil);
    }

    /**
     * Status must be a non-negative integer, a string, or the atom abort.
     * Halts the Erlang runtime system.
     * Has no return value.
     * Depending on Status:
     *
     * integer()::
     * The runtime system exits with the integer value Status as status code
     * to the calling environment (operating system).
     *
     * string()::
     * An erlang crash dump is produced with Status as slogan,
     * and then the runtime system exits with status code 1.
     *
     * abort::
     * The runtime system aborts producing a core dump,
     * if that is enabled in the operating system.
     *
     * Note that on many platforms, only the status codes 0-255 are
     * supported by the operating system.
     *
     * For integer Status the Erlang runtime system closes all ports and
     * allows async threads to finish their operations before exiting.
     * To exit without such flushing use Option as {flush,false}.
     *
     * For statuses string() and abort the flush option is ignored and
     * flushing is not done.
     */
    public static void halt_2(Term status, List options) {
        if (status instanceof Integer) {
            System.exit(((Integer) status).toInt());
        } else {
            System.exit(0);
        }
    }

    /**
     * Returns the head of List, that is, the first element.
     * Allowed in guard tests.
     * Failure: `badarg` if `list` is the empty list `[]`.
     */
    public static Term hd(List list) {
        if (list.equals(List.nil)) {
            error(Atom.of("badarg"));
        }
        return list.head();
    }

    /**
     * Returns a binary which corresponds to the text representation of Integer.
     *
     * http://www.erlang.org/doc/man/erlang.html#integer_to_binary-1
     */
    public static Term integer_to_binary(List params) {
        switch (length_1(params).toInt()) {
        case 1:
            return integer_to_binary_1(params.head().toInteger());
        case 2:
            Integer integer = params.head().toInteger();
            params = params.tail();
            Integer base = params.head().toInteger();
            return integer_to_binary_2(integer, base);
        default:
            throw new Error("badarg");
        }
    }

    public static Binary integer_to_binary_1(Integer integer) {
        return new Binary(integer.toString().getBytes(ISO_8859_1));
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#integer_to_binary-2
     */
    public static Binary integer_to_binary_2(Integer integer, Integer base) {
        return new Binary(integer.toBigInteger().toString(base.toInt()).getBytes(ISO_8859_1));
    }

    /**
     * Returns a string which corresponds to the text representation of Integer.
     *
     * http://www.erlang.org/doc/man/erlang.html#integer_to_list-1
     */
    public static Term integer_to_list(List params) {
        switch (length_1(params).toInt()) {
        case 1:
            return integer_to_list_1(params.head().toInteger());
        case 2:
            Integer integer = params.head().toInteger();
            params = params.tail();
            Integer base = params.head().toInteger();
            return integer_to_list_2(integer, base);
        default:
            throw new Error("badarg");
        }
    }

    public static List integer_to_list_1(Integer integer) {
        return new Str(integer.toString());
    }

    /**
     * Returns a string which corresponds to the text representation of Integer
     * in base Base.
     *
     * http://www.erlang.org/doc/man/erlang.html#integer_to_list-2
     */

    public static List integer_to_list_2(Integer integer, Integer base) {
        return new Str(integer.toBigInteger().toString(base.toInt()));
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_atom-1
     */
    public static boolean is_atom(Term term) {
        return (term instanceof Atom);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_binary-1
     */
    public static boolean is_binary(Term term) {
        return (term instanceof Binary);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_boolean-1
     */
    public static boolean is_boolean(Term term) {
        if (term instanceof Atom) {
            switch (term.toString()) {
            case "false":
            case "true":
                return true;
            }
        }
        return false;
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_function-1
     */
    public static boolean is_function(Term term) {
        return (term instanceof Fun);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_integer-1
     */
    public static boolean is_integer(Term term) {
        return (term instanceof Integer);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_list-1
     */
    public static boolean is_list(Term term) {
        return (term instanceof List);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_map-1
     */
    public static boolean is_map(Term term) {
        return (term instanceof Map);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_number-1
     */
    public static boolean is_number(Term term) {
        return (term instanceof Number);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_pid-1
     */
    public static boolean is_pid(Term term) {
        return (term instanceof PID);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#is_tuple-1
     */
    public static boolean is_tuple(Term term) {
        return (term instanceof Tuple);
    }

    /**
     * Returns the length of List.
     *
     * http://www.erlang.org/doc/man/erlang.html#length-1
     */
    public static Term length(List params) {
        switch (length_1(params).toInt()) {
        case 1:
            List list = params.head().toList();
            return length_1(list);
        default:
            throw new Error("badarg");
        }
    }

    public static Integer length_1(List list) {
        if (list == List.nil) {
            return new Integer(0);
        }
        int length = 0;
        while (list.head() != null) {
            list = list.tail();
            length++;
        }
        return new Integer(length);
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#process_flag-2
     */
    public static boolean process_flag(Atom flag, boolean value) {
        return ProcessFlag.process_flag(flag, value);
    }

    /**
     * Associates the name RegName with a pid or a port identifier.
     * RegName, which must be an atom, can be used instead of the
     * pid / port identifier in the send operator (RegName ! Message).
     *
     * http://www.erlang.org/doc/man/erlang.html#register-2
     */
    public static boolean register(Atom regName, PID pid) {
        ProcessRegistry.register(regName, pid);
        return true;
    }

    /**
     * http://www.erlang.org/doc/man/erlang.html#self-0
     */
    public static PID self() {
        return new PID(0); // TODO
    }

    /**
     * Returns the pid of a new process started by the application of
     * Fun to the empty list []. Otherwise works like spawn/3.
     *
     * http://www.erlang.org/doc/man/erlang.html#spawn-1
     */
    public static PID spawn(Object fun) {
        return new PID(0); // TODO
    }

    /**
     * Returns an integer which is the number of elements in `tuple`.
     */
    public static Integer tuple_size(Tuple tuple) {
        return Integer.of(tuple.arity());
    }

    /**
     * Returns a list which corresponds to Tuple.
     * Tuple may contain any Erlang terms.
     */
    public static List tuple_to_list(Tuple tuple) {
        List list = new List();
        for (int index = tuple.arity() - 1; index >= 0; index--) {
            list = new List(tuple.element(index), list);
        }
        return list;
    }

}
