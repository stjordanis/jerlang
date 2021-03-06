package org.jerlang.erts;

import org.jerlang.erts.erlang.ErlangAbs;
import org.jerlang.erts.erlang.ErlangApply;
import org.jerlang.erts.erlang.ErlangAtomMinus;
import org.jerlang.erts.erlang.ErlangAtomMultiply;
import org.jerlang.erts.erlang.ErlangAtomPlus;
import org.jerlang.erts.erlang.ErlangAtomPlusPlus;
import org.jerlang.erts.erlang.ErlangBinaryPart;
import org.jerlang.erts.erlang.ErlangBitstringToList;
import org.jerlang.erts.erlang.ErlangByteSize;
import org.jerlang.erts.erlang.ErlangDisplay;
import org.jerlang.erts.erlang.ErlangError;
import org.jerlang.erts.erlang.ErlangFunctionExported;
import org.jerlang.erts.erlang.ErlangGet;
import org.jerlang.erts.erlang.ErlangGetKeys;
import org.jerlang.erts.erlang.ErlangGetModuleInfo;
import org.jerlang.erts.erlang.ErlangHalt;
import org.jerlang.erts.erlang.ErlangHd;
import org.jerlang.erts.erlang.ErlangIntegerToBinary;
import org.jerlang.erts.erlang.ErlangIntegerToList;
import org.jerlang.erts.erlang.ErlangIsAtom;
import org.jerlang.erts.erlang.ErlangIsBinary;
import org.jerlang.erts.erlang.ErlangIsBitstr;
import org.jerlang.erts.erlang.ErlangIsBoolean;
import org.jerlang.erts.erlang.ErlangIsFunction;
import org.jerlang.erts.erlang.ErlangIsInteger;
import org.jerlang.erts.erlang.ErlangIsList;
import org.jerlang.erts.erlang.ErlangIsMap;
import org.jerlang.erts.erlang.ErlangIsNumber;
import org.jerlang.erts.erlang.ErlangIsPid;
import org.jerlang.erts.erlang.ErlangIsRecord;
import org.jerlang.erts.erlang.ErlangIsReference;
import org.jerlang.erts.erlang.ErlangIsTuple;
import org.jerlang.erts.erlang.ErlangLength;
import org.jerlang.erts.erlang.ErlangListToAtom;
import org.jerlang.erts.erlang.ErlangListToBitstring;
import org.jerlang.erts.erlang.ErlangListToInteger;
import org.jerlang.erts.erlang.ErlangMakeRef;
import org.jerlang.erts.erlang.ErlangOpenPort;
import org.jerlang.erts.erlang.ErlangPortClose;
import org.jerlang.erts.erlang.ErlangPortControl;
import org.jerlang.erts.erlang.ErlangProcessFlag;
import org.jerlang.erts.erlang.ErlangPut;
import org.jerlang.erts.erlang.ErlangRegister;
import org.jerlang.erts.erlang.ErlangRem;
import org.jerlang.erts.erlang.ErlangSelf;
import org.jerlang.erts.erlang.ErlangSendAfter;
import org.jerlang.erts.erlang.ErlangSetelement;
import org.jerlang.erts.erlang.ErlangSpawn;
import org.jerlang.erts.erlang.ErlangSystemInfo;
import org.jerlang.erts.erlang.ErlangThrow;
import org.jerlang.erts.erlang.ErlangTl;
import org.jerlang.erts.erlang.ErlangTupleSize;
import org.jerlang.erts.erlang.ErlangTupleToList;
import org.jerlang.exception.ThrowException;
import org.jerlang.type.Atom;
import org.jerlang.type.Binary;
import org.jerlang.type.BitString;
import org.jerlang.type.Fun;
import org.jerlang.type.Integer;
import org.jerlang.type.List;
import org.jerlang.type.PID;
import org.jerlang.type.PortID;
import org.jerlang.type.Reference;
import org.jerlang.type.Str;
import org.jerlang.type.Term;
import org.jerlang.type.TimerReference;
import org.jerlang.type.Tuple;

/**
 * http://www.erlang.org/doc/man/erlang.html
 */
public class Erlang {

    public static Integer atom_minus(Integer a, Integer b) {
        return ErlangAtomMinus.atom_minus_2(a, b);
    }

    public static Integer atom_multiply(Integer a, Integer b) {
        return ErlangAtomMultiply.atom_multiply_2(a, b);
    }

    public static Integer atom_plus(Integer a, Integer b) {
        return ErlangAtomPlus.atom_plus_2(a, b);
    }

    public static List atom_plus_plus(List a, List b) {
        return ErlangAtomPlusPlus.atom_plus_plus_2(a, b);
    }

    // --------------------------------------------------------------

    public static Integer abs(Integer integer) {
        return ErlangAbs.abs_1(integer);
    }

    public static Term apply(Term m, Term f, Term a) throws Error {
        return ErlangApply.apply_3(m, f, a);
    }

    public static Binary binary_part(Binary subject, Tuple posLen) {
        return ErlangBinaryPart.binary_part_2(subject, posLen);
    }

    public static Binary binary_part(Binary subject, Integer start, Integer length) {
        return ErlangBinaryPart.binary_part_3(subject, start, length);
    }

    public static List bitstring_to_list(BitString bitString) {
        return ErlangBitstringToList.bitstring_to_list_1(bitString);
    }

    public static Integer byte_size(BitString bitString) {
        return ErlangByteSize.byte_size_1(bitString);
    }

    public static Term display(Term term) {
        return ErlangDisplay.display_1(term);
    }

    public static void error(Term reason) {
        ErlangError.error_1(reason);
    }

    public static void error(Term reason, List where) {
        ErlangError.error_2(reason, where);
    }

    public static Term function_exported(Atom module, Atom function, Integer arity) {
        return ErlangFunctionExported.function_exported_3(module, function, arity);
    }

    public static List get() {
        return ErlangGet.get_0();
    }

    public static Term get(Term key) {
        return ErlangGet.get_1(key);
    }

    public static List get_keys() {
        return ErlangGetKeys.get_keys_0();
    }

    public static List get_keys(Term value) {
        return ErlangGetKeys.get_keys_1(value);
    }

    public static Term get_module_info(Atom module, Atom item) {
        return ErlangGetModuleInfo.get_module_info_2(module, item);
    }

    public static void halt() {
        ErlangHalt.halt_0();
    }

    public static void halt(Term status) {
        ErlangHalt.halt_1(status);
    }

    public static void halt(Term status, List options) {
        ErlangHalt.halt_2(status, options);
    }

    public static Term hd(List list) {
        return ErlangHd.hd_1(list);
    }

    public static Binary integer_to_binary(Integer integer) {
        return ErlangIntegerToBinary.integer_to_binary_1(integer);
    }

    public static Binary integer_to_binary(Integer integer, Integer base) {
        return ErlangIntegerToBinary.integer_to_binary_2(integer, base);
    }

    public static Str integer_to_list(Integer integer) {
        return ErlangIntegerToList.integer_to_list_1(integer);
    }

    public static List integer_to_list(Integer integer, Integer base) {
        return ErlangIntegerToList.integer_to_list_2(integer, base);
    }

    public static Term is_atom(Term term) {
        return ErlangIsAtom.is_atom_1(term);
    }

    public static Term is_binary(Term term) {
        return ErlangIsBinary.is_binary_1(term);
    }

    public static Term is_bitstr(Term term) {
        return ErlangIsBitstr.is_bitstr_1(term);
    }

    public static Term is_boolean(Term term) {
        return ErlangIsBoolean.is_boolean_1(term);
    }

    public static Term is_function(Term term) {
        return ErlangIsFunction.is_function_1(term);
    }

    public static Term is_integer(Term term) {
        return ErlangIsInteger.is_integer_1(term);
    }

    public static Term is_list(Term term) {
        return ErlangIsList.is_list_1(term);
    }

    public static Term is_map(Term term) {
        return ErlangIsMap.is_map_1(term);
    }

    public static Term is_number(Term term) {
        return ErlangIsNumber.is_number_1(term);
    }

    public static Term is_pid(Term term) {
        return ErlangIsPid.is_pid_1(term);
    }

    public static Term is_record(Term term, Term recordTag) {
        return ErlangIsRecord.is_record_2(term, recordTag);
    }

    public static Term is_reference(Term term) {
        return ErlangIsReference.is_reference_1(term);
    }

    public static Term is_tuple(Term term) {
        return ErlangIsTuple.is_tuple_1(term);
    }

    public static Integer length(List list) {
        return ErlangLength.length_1(list);
    }

    public static Atom list_to_atom(List string) {
        return ErlangListToAtom.list_to_atom_1(string);
    }

    public static BitString list_to_bitstring(List list) {
        return ErlangListToBitstring.list_to_bitstring_1(list);
    }

    public static Integer list_to_integer(List string) {
        return ErlangListToInteger.list_to_integer_1(string);
    }

    public static Integer list_to_integer(List string, Integer base) {
        return ErlangListToInteger.list_to_integer_2(string, base);
    }

    public static Reference make_ref() {
        return ErlangMakeRef.make_ref_0();
    }

    public static PortID open_port(Tuple portName, List portSettings) {
        return ErlangOpenPort.open_port_2(portName, portSettings);
    }

    public static Atom port_close(Term port) {
        return ErlangPortClose.port_close_1(port);
    }

    public static Term port_control(Term portId, Integer operation, Term data) {
        return ErlangPortControl.port_control_3(portId, operation, data);
    }

    public static Term process_flag(Atom flag, Term value) {
        return ErlangProcessFlag.process_flag_2(flag, value);
    }

    public static Term put(Term key, Term val) {
        return ErlangPut.put_2(key, val);
    }

    public static Term register(Atom regName, PID pid) {
        return ErlangRegister.register_2(regName, pid);
    }

    public static Integer rem(Integer a, Integer b) {
        return ErlangRem.rem_2(a, b);
    }

    public static PID self() {
        return ErlangSelf.self_0();
    }

    public static TimerReference send_after(Integer time, PID pid, Term msg) {
        return ErlangSendAfter.send_after_3(time, pid, msg);
    }

    public static Tuple setelement(Integer index, Tuple tuple, Term value) {
        return ErlangSetelement.setelement_3(index, tuple, value);
    }

    public static PID spawn(Fun fun) {
        return ErlangSpawn.spawn_1(fun);
    }

    public static PID spawn(Atom m, Atom f, List a) {
        return ErlangSpawn.spawn_3(m, f, a);
    }

    public static Term system_info(Term term) {
        return ErlangSystemInfo.system_info_1(term);
    }

    public static void _throw(Term reason) throws ThrowException {
        ErlangThrow.throw_1(reason);
    }

    public static Term tl(List list) {
        return ErlangTl.tl_1(list);
    }

    public static Integer tuple_size(Tuple tuple) {
        return ErlangTupleSize.tuple_size_1(tuple);
    }

    public static List tuple_to_list(Tuple tuple) {
        return ErlangTupleToList.tuple_to_list_1(tuple);
    }

}
