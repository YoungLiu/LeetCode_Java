/*Given an Iterator class interface with methods: next() and hasNext(),
        design and implement a PeekingIterator that support the peek() operation --
        it essentially peek() at the element that will be returned by the next call to next().

        Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

        Call next() gets you 1, the first element in the list.

        Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

        You call next() the final time and it returns 3, the last element. Calling hasNext()
        after that should return false.*/

package com.computinglife.leetcode.medium;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by YanceyLiu on 5/28/2016.
 */
public class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekNum;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer next = peekNum;
        hasPeeked = false;
        peekNum = null;
        return next;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            hasPeeked = true;
            peekNum = iterator.next();
        }
        return peekNum;
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {

    }

    @Override
    public void remove() {

    }
}
