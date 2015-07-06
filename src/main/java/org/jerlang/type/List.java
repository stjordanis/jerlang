package org.jerlang.type;

public class List extends Term {

    public static final Nil nil = new Nil();

    private Term head;
    private List tail;

    public List(Term head) {
        this.head = head;
        this.tail = nil;
    }

    public List(Term head, List tail) {
        this.head = head;
        this.tail = tail;
    }

    public Term head() {
        return head;
    }

    public List tail() {
        return tail;
    }

}
