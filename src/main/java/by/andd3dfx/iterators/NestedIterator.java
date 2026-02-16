package by.andd3dfx.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/description/">Task description</a>
 *
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers
 * or other lists. Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *     NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 *     int next() Returns the next integer in the nested list.
 *     boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 *
 * Your code will be tested with the following pseudocode:
 *
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 *     append iterator.next() to the end of res
 * return res
 *
 * If res matches the expected flattened list, then your code will be judged as correct.
 *
 * Example 1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 *
 * Example 2:
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * </pre>
 */
public class NestedIterator implements Iterator<Integer> {

    private final Deque<Iterator<INestedInteger>> stack = new ArrayDeque<>();
    private Integer nextElement;

    public NestedIterator(List<INestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        var result = determineNextElement();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (nextElement != null) {
            return true;
        }
        nextElement = determineNextElement();
        return nextElement != null;
    }

    private Integer determineNextElement() {
        if (nextElement != null) {
            var result = nextElement;
            nextElement = null;
            return result;
        }

        while (!stack.isEmpty()) {
            Iterator<INestedInteger> iterator = stack.peek();
            if (iterator.hasNext()) {
                var next = iterator.next();

                if (next.isInteger()) {
                    return next.getInteger();
                } else {
                    stack.push(next.getList().iterator());
                    return determineNextElement();
                }
            } else {
                stack.pop();
            }
        }
        return null;
    }

    public interface INestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<INestedInteger> getList();
    }
}
