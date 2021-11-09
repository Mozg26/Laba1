package com.company;

/**
 * A class representing a list item with a pointer to the next item.
 * @param <T> Item data type
 */
class Element <T>{
    /**
     * The value of the list item.
     */
    T value;
    /**
     * A pointer to the next item in the list.
     */
    Element<T> next;

    /**
     * Constructor of the Element class.
     */
    Element() {}
}

/**
 * List class with elements of the Element class (pointers to the beginning and end of the list).
 * @param <T> List data type
 */
public class Set <T> {
    /**
     * Pointer to the beginning of the list.
     */
    private Element<T> head;
    /**
     * Pointer to the end of the list.
     */
    private Element<T> tail;

    /**
     * The method that sets the new beginning of the list.
     * @param t The list item that will be the new beginning of the list.
     */
    protected void setHead(Element<T> t) {
        this.head = t;
    }

    /**
     * The method that sets the new end of the list.
     * @param t The list item that will be the new end of the list.
     */
    protected void setTail(Element<T> t) {
        this.tail = t;
    }

    /**
     * Class constructor that creates an empty list.
     */
    Set() {}

    /**
     * Class constructor that creates a list and initializes the first element of the list.
     * @param data The value of the first item in the list.
     */

    Set(T data) {
        Element<T> elem = new Element<>();
        elem.next = null;
        elem.value = data;
        this.head = elem;
        this.tail = elem;
    }

    /**
     * A method that returns the element that is the beginning of the list.
     * @return The element that is the beginning of the list.
     */
    Element<T> getHead() {
        return this.head;
    }

    /**
     * A method that returns the element that is the end of the list.
     * @return The element that is the end of the list.
     */
    Element<T> getTail() {
        return this.tail;
    }

    /**
     * A method that adds a new item to the top of the list.
     * @param data The value of the new list item.
     */
    void addition_head(T data) {

        if (!this.search(data)) {
            Element <T> temp = new Element<>();
            temp.value = data;

            if (this.head == null) {
                this.setHead(temp);
            }

            else {
                temp.next = this.head;
                this.head = temp;
            }
        }
    }

    /**
     * A method that adds a new item to the end of the list.
     * @param data The value of the new list item.
     */
    void addition_tail(T data) {

        if (!this.search(data)) {
            Element<T> temp = new Element<>();
            temp.value = data;
            temp.next = null;

            if (this.tail == null) {
                this.setTail(temp);
            }

            else {
                this.tail.next = temp;
                this.tail = temp;
            }
        }
    }

    /**
     * Method of searching for an item in the list.
     * @param data The value of the element to be found
     * @return True if the item in the list exists, and False if it is missing
     */
    boolean search(T data) {

        for(Element<T> tmp = this.head; tmp != null; tmp = tmp.next) {
            if (tmp.value == data) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method of removing an item from the list.
     * @param data The value of the element to be deleted.
     */
    void delete_elem(T data) {

        if (this.head != null) {

            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }

            else if (this.head.value == data)
                this.head = this.head.next;

            else {
                for(Element<T> tmp = this.head; tmp.next != null; tmp = tmp.next) {
                    if (tmp.next.value == data) {

                        if (this.tail == tmp.next)
                            this.tail = tmp;

                        tmp.next = tmp.next.next;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Method of comparing two lists.
     * @param list The list to be compared with.
     * @return True if lists are equal and false if not
     */
    boolean comp(Set<T> list) {
        Element<T> a = list.head;
        Element<T> b;

        for(b = this.head; a != null && b != null; b = b.next) {
            if (a.value != b.value)
                return false;

            a = a.next;
        }
        return a == null && b == null;
    }

    /**
     * The method for displaying the list to the console.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Element<T> current = head;

        while(current != null){
            result.append(current.value);

            if(current.next != null){
                result.append(", ");
            }

            current = current.next;
        }

        return "List: " + result;
    }

    /**
     * Redefined method from the Object class
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Set<T> exp = (Set<T>) obj;
        Element<T> a = exp.head;
        Element<T> b;

        for(b = this.head; a != null && b != null; b = b.next) {
            if (a.value != b.value)
                return false;

            a = a.next;
        }
        return true;
    }
}
