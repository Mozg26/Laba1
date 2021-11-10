package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests of the List class
 */
public class ListTest {

    /**
     * Unit test of the addition_head() method
     */
    @Test
    public void addition_head() {
        int data = 5;
        Set<Integer> actual = new Set<>(3);
        actual.addition_head(data);
        Set<Integer> expected = new Set<>(3);
        Element<Integer> tmp = new Element<>();
        tmp.next = expected.getHead();
        tmp.value = data;
        expected.setHead(tmp);
        assertEquals(expected, actual);
    }

    /**
     * Unit test of the addition_tail() method
     */
    @Test
    public void addition_tail() {
        int data = 5;
        Set<Integer> actual = new Set<>(3);
        actual.addition_tail(data);
        Set<Integer> expected = new Set<>(3);
        Element<Integer> tmp = new Element<>();
        tmp.next = null;
        tmp.value = data;
        expected.getTail().next = tmp;
        expected.setTail(tmp);
        assertEquals(expected, actual);

    }

    /**
     * Unit test of the search() method
     */
    @Test
    public void search() {
        int data = 3;
        Set<Integer> arr = new Set<>(1);

        for(int i = 2; i < 6; ++i) {
            arr.addition_tail(i);
        }

        assertTrue(arr.search(data));
    }

    /**
     * Unit test of the delete_elem() method
     */
    @Test
    public void delete_elem() {
        int data = 5;
        Set<Integer> expected = new Set<>();

        for(int i = 2; i < 6; ++i) {
            expected.addition_tail(i);
        }

        expected.delete_elem(data);
        Set<Integer> actual = new Set<>();

        for(int i = 2; i < 5; ++i) {
            actual.addition_tail(i);
        }

        assertEquals(actual,expected);
    }
}