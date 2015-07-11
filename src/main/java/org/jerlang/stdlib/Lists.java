package org.jerlang.stdlib;

import org.jerlang.ModuleRegistry;
import org.jerlang.type.List;

/**
 * http://www.erlang.org/doc/man/lists.html
 */
public class Lists {

    static {
        ModuleRegistry.register("file")
            .export("reverse", 1);
    }

    public static List reverse(List list) {
        if (list.equals(List.nil)) {
            return list;
        }
        if (list.tail().equals(List.nil)) {
            return list;
        }
        List result = List.nil;
        while (list != List.nil) {
            result = new List(list.head(), result);
            list = list.tail();
        }
        return result;
    }

}