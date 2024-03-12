import static org.junit.jupiter.api.Assertions.*;

// # test messages for each. no items, 1 item, 3 items

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(0), 42);
        //Sting out = theList.toString();
        //assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addBackNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(theList.size()-1), 42);
        //Sting out = theList.toString();
        //assertEquals(out, "[1, 2, 3, 42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY 10
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        // add item 11
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);

    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        // Create Empty List
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class,
                () -> {theList.removeBack();
        });
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList() {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        // Create List
        ArrayIntList theList = new ArrayIntList();

        //fill with 10 items
        for(int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        // remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}