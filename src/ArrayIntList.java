import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {
    // internal (private) representation
    private int[] buffer;
    private int size;       // num of spots used in array
    private final static int INITIAL_CAPACITY = 10;

    public ArrayIntList() {
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */

    // relatively slow, linear time (size dependent) O(size), resize = slow O(2n)
    @Override
    public void addFront(int value) {

        //check if full
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        // open spot at index 0 where value will be saved
        // shift everything right 1
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }

        // put value in position 0
        buffer[0] = value;

        size++;
    }

    //Works slow, linear time O(n) or O(size)
    private void resize(int newSize) {
        // create new array of new size
        int[] temp = new int[newSize];

        //copy over the values from the existing buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }

        // make the switch over
        buffer = temp;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */

    // Works fast, constant O(1), (unless array is resized then slow linear time)
    @Override
    public void addBack(int value) {
        // Check to see if we still have room (capacity)
        if (size == buffer.length) {
            // Create new larger array to resize and copy over values

            // new size is double existing capacity
            resize(2 * buffer.length);
        }

        buffer[size] = value;
        size++;
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

    // run time between add back constant O(1) and add front linear O(n)
    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Doesn't fit index");
        capacity(size + 1);
        for (int i = size; i > index; i--)
            buffer[i] = buffer[i - 1];
        buffer[index] = value;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */

    // Works slow, linear time O(N)
    @Override
    public void removeFront() {
        if (size == 0) {
            throw new IllegalStateException("already empty");
        }
        size--;
        buffer[size] = 0;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */

    // fast, constant time O(1)
    @Override
    public void removeBack() {
        if (size == 0) {
            throw new IllegalStateException("already empty");
        }

        size--;
        buffer[size] = 0;
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

    // Works slow if removing front linear O(n), fast if removing back constant O(1)
    @Override
    public int remove(int index) {
        if (size == 0) {
            throw new IllegalStateException("already empty");
        }
        return index;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    // Works quickly, constant time, O(1)    ex: buffer[2024] get[4]
    @Override
    public int get(int index) {
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */

    // fast if at index 0,          slow if at end or not available
    // constant O(1) = best case    linear O(n) = worst case
    @Override
    public boolean contains(int value) {
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */

    // fast if at index 0,          slow if at end or not available
    // constant O(1) = best case    linear O(n) = worst case
    @Override
    public int indexOf(int value) {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */

    // fast if at index 0,          slow if at end or not available
    // constant O(1) = best case    linear O(n) = worst case
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */

    // fast constant, O(1)
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator();
    }

    // linear time O(n), have to visit every item
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 1; i < size; i++) {
            sb.append(", ");
            sb.append(buffer[i]);
        }

        sb.append("]");
        return sb.toString();
    }

    //Nested class
    public class ArrayIntListIterator implements Iterator<Integer> {
        private int currentPosition;

        public ArrayIntListIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return (currentPosition < size);
        }

        @Override
        public Integer next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }

} //end of array int list

