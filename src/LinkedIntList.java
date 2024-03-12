import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {
    // helper inner/nested class
    public class Node {
        int data;       // holds value
        Node next;      // holds address

        public Node() {
            data = 0;
            next = null;
        }

        // T = 2 is O(1) constant time

        public Node(int data, Node next) {
            this.data = data;       // this = address of object currently in
            this.next = next;
        }
    } // end of class node

    // fields of LinkedIntList class
    private Node head;      // address of first node in list
    private int size;       // number of nodes/items in list

    /**
     * T = 2 is O(1) constant
     */

    public LinkedIntList() {
        head = null;
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * T = 7 is O(1) constant
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        // if the list is empty
        if (head == null) {
            head = new Node(value, null);
        } else {

            // if list is not empty
            head = new Node(value, head);
        }

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * Empty list T = 5 which is O(1) constant time
     * Not empty (into else) T = 2n + 6 which is O(n) linear time
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // if list is empty
        if (head == null) {
            head = new Node(value, null);
            size ++;
            return;
        }

        // if list is not empty
        Node current = head;


        //loop and stop at last node that is not null
        while (current.next != null){
            // move current forward
            current = current.next;
        }

        // current is referencing the last node
        current.next = new Node(value, null);
        size ++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(head != null) {
            head = null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = curent.next;
        }
        current.next = null;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (index == 0) {
            front = front.next;
        }else {
            return front;
        }
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * O(n) linear - to get item at index, iterate through list
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        return 0;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * T = O(1) constant
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * empty list T = O(1) constant
     * full list  T = O(n) linear
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * T = O(1) constant
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * T = O(n) linear
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     *
     * Clear empty list or 1 value T = O(1)
     * Clear multipal values  T = O(n)
     */
    @Override
    public void clear() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * T = O(n)
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIterator();
    }

    // helper method
    public void print() {
        // create temp variable
        // copy in the address frim head and save it
        Node current = head;

        while (current != null) {
            //print the value inside the node
            System.out.println(current.data);

            // go to next node
            current = current.next;
        }
    }

    // O(n)

    @Override
    public String toString() {
        if (head == null) {

            // if list is empty, indicate with brackets
            return "[]";
        }

        // if list is not empty
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while (current != null) {
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }

        // add in the last node
        sb.append(current.data);

        sb.append("]");
        return sb.toString();
    }

    // helper class
    public class LinkedIterator implements Iterator<Integer> {

        //keep track of current position
        private Node current;   //holds address of current node

        public LinkedIterator() {
            // start the current position at the first node in the list
            current = head;
        }

        // O(1)
        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            } else {
                return true;
            }
        }

        // O(n)
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }
    }
}
