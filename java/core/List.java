package core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// A Scala-like immutable List implementation in Java (without higher-order function)
// The performance is not considered in favor of cleaner code (for demo purposes)
public class List<T> implements Iterable<T> {
    private static final List NIL = new EmptyList();
            
    private final T _head;
    
    private final List<T> _tail;

    
    private List(T head, List<T> tail) {
        _head = head;
        _tail = tail;
    }
    
    public T head() {
        return _head;
    }

    public List<T> tail() {
        return _tail;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean nonEmpty() {
        return !isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> nil() {
        return NIL;
    }

    public static List<Character> listOfChars(String chars) {
        List<Character> list = nil();
        for (Character each : chars.toCharArray())
            list = cons(each, list);
        return list.reverse();
    }

    public static <T> List<T> list(T... elements) {
        return list(Arrays.asList(elements));
    }

    public static <T> List<T> list(Iterable<T> elements) {
        List<T> list = nil();
        for (T each : elements)
            list = cons(each, list);
        return list.reverse();
    }

    public static <T> List<T> singleton(T element) {
        return new List<T>(element, List.<T>nil());
    }

    public static <T> List<T> replicate(int n, T element) {
        List<T> list = nil();
        for (int i = 0; i < n; i++)
            list = cons(element, list);
        return list;
    }

    public static List<Integer> range(int a, int b) {
        if (a > b) {
            return nil();
        } else {
            return cons(a, range(a + 1, b));
        }
    }

    public static <T> List<T> cons(T head, List<T> tail) {
        return new List<T>(head, tail);
    }
    
    public static <T> List<T> concat(List<T> prefix, List<T> suffix) {
        List<T> result = suffix;
        for (T each : prefix.reverse())
            result = cons(each, result);
        return result;
    }

    public List<T> prepend(T head) {
        return cons(head, this);
    }

    public List<T> prepend(List<T> prefix) {
        return concat(prefix, this);
    }

    public List<T> append(List<T> suffix) {
        return concat(this, suffix);
    }

    public List<T> reverse() {
        List<T> list = nil();
        for (T each : this)
            list = cons(each, list);
        return list;
    }
    
    public int length() {
        int c = 0;
        for (T each : this)
            c++;
        return c;
    }

    public T get(int i) {
        int c = 0;
        for (T each : this)
            if (c == i)
                return each;
            else
                c++;
        throw new IndexOutOfBoundsException();
    }
    
    public T last() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T result = null;
        for (T each : this)
            result = each;
        return result;
    }

    public List<T> take(int i) {
        return take(i, this).reverse();
    }

    public List<T> takeRight(int i) {
        return take(i, this.reverse());
    }

    private static <T> List<T> take(int i, List<T> list) {
        List<T> result = nil();
        int c = 0;
        for (T each : list) {
            if (c == i) break;
            result = cons(each, result);
            c++;
        }
        return result;
    }

    public List<T> drop(int i) {
        return drop(i, this).reverse();
    }

    public List<T> dropRight(int i) {
        return drop(i, this.reverse());
    }

    private static <T> List<T> drop(int i, List<T> list) {
        List<T> result = nil();
        int c = i;
        for (T each : list) {
            c--;
            if (c >= 0) continue;
            result = cons(each, result);
        }
        return result;
    }

    public List<T> init() {
        if (isEmpty()) throw new UnsupportedOperationException("List is empty");
        return dropRight(1);
    }

    public Pair<List<T>, List<T>> splitAt(int index) {
        return Pair.pair(take(index), drop(index));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof List)) return false;

        Iterator ours = this.iterator();
        Iterator theirs = ((List) obj).iterator();

        while (ours.hasNext() && theirs.hasNext())
            if (!ours.next().equals(theirs.next()))
                return false;

        return !ours.hasNext() && !theirs.hasNext();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            builder.append(it.next());
            if (it.hasNext()) builder.append(", ");
        }
        builder.append(']');
        return builder.toString();
    }


    private static class EmptyList extends List<Object> {
        public EmptyList() {
            super(null, null);
        }

        @Override
        public Object head() {
            throw new IllegalStateException("Accessing head of the an empty list");
        }

        @Override
        public List<Object> tail() {
            throw new IllegalStateException("Accessing tail of the an empty list");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    private class ListIterator<T> implements Iterator<T> {
        private List<T> _list;

        public ListIterator(List<T> list) {
            _list = list;
        }

        @Override
        public boolean hasNext() {
            return !_list.isEmpty();
        }

        @Override
        public T next() {
            T value = _list.head();
            _list = _list.tail();
            return value;  
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}