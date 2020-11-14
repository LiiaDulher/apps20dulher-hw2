package ua.edu.ucu.collections.immutable;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    // testing add(Object)

    @Test
    public void testImmutableAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String s = "7";
        ImmutableArrayList arr1 = arr.add(s);
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyArrayAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String s = "7";
        ImmutableArrayList arr1 = arr.add(s);

        String[] expResult ={"7"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementArrayAdd() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String s2 = "10";
        ImmutableArrayList arr1 = arr.add(s2);

        String[] expResult ={"5", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAdd() {
        String[] s1 = {"5", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String s2 =  "10";
        ImmutableArrayList arr1 = arr.add(s2);

        String[] expResult ={"5", "12", "10"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing add(index, Object)

    @Test
    public void testImmutableIndexAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String s = "7";
        ImmutableArrayList arr1 = arr.add(0, s);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeIndexAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String s = "7";
        ImmutableArrayList arr1 = arr.add(12, s);
    }

    @Test
    public void testOneElementArrayIndexAdd() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String s2 = "7";
        ImmutableArrayList arr1 = arr.add(0, s2);

        String[] expResult ={"7", "5"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAdd() {
        String[] s1 = {"5", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String s2 = "7";
        ImmutableArrayList arr1 = arr.add(1, s2);

        String[] expResult ={"5", "7", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing addAll(Object[])

    @Test
    public void testImmutableAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String[] s = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(s);
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyArrayAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String[] s = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(s);

        String[] expResult ={"7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementArrayAddAll() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String[] s2 = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(s2);

        String[] expResult ={"5", "7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddAll() {
        String[] s1 = {"5", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String[] s2 = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(s2);

        String[] expResult ={"5", "12", "7", "10"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing addAll(index, Object[])

    @Test
    public void testImmutableIndexAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String[] s = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(0, s);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeIndexAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String[] s = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(12, s);
    }

    @Test
    public void testOneElementArrayIndexAddAll() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String[] s2 = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(1, s2);

        String[] expResult ={"5", "7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAddAll() {
        String[] s1 = {"5", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String[] s2 = {"7", "10"};
        ImmutableArrayList arr1 = arr.addAll(1, s2);

        String[] expResult ={"5", "7", "10", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing get()

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeGet() {
        String[] s = {"7", "10"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        Object s1 = arr.get(12);
    }

    @Test
    public void testOneElementArrayGet() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        String expResult ="5";
        Object actualResult = arr.get(0);

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGet() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        String expResult = "10";
        Object actualResult = arr.get(2);
        assertEquals(expResult, actualResult);
    }

    // testing remove()

    @Test
    public void testImmutableRemove() {
        String[] s ={"7"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        ImmutableArrayList arr1 = arr.remove(0);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeRemove() {
        String[] s = {"7", "10"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        ImmutableArrayList arr1 = arr.remove(2);
    }

    @Test
    public void testOneElementArrayRemove() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        ImmutableArrayList arr1 = arr.remove(0);

        String[] expResult =new String[0] ;
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testRemove() {
        String[] s1 = {"5", "10", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        ImmutableArrayList arr1 = arr.remove(1);

        String[] expResult ={"5", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing set()

    @Test
    public void testImmutableSet() {
        String[] s ={"7", "10"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        ImmutableArrayList arr1 = arr.set(1, "15");
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeSet() {
        String[] s = {"7", "10"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        ImmutableArrayList arr1 = arr.set(2, "18");
    }

    @Test
    public void testOneElementArraySet() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        ImmutableArrayList arr1 = arr.set(0, "98");

        String[] expResult = {"98"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testSet() {
        String[] s1 = {"5", "10", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        ImmutableArrayList arr1 = arr.set(1, "7");

        String[] expResult ={"5", "7", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing indexOf()

    @Test
    public void testNoElementIndexOf() {
        String[] s1 = {"5", "7"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        int expResult = -1;
        int actualResult = arr.indexOf("10");

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        int expResult = 2;
        int actualResult = arr.indexOf("10");
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSameIndexOf() {
        String[] s1 = {"5", "7", "7", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        int expResult = 1;
        Object actualResult = arr.indexOf("7");
        assertEquals(expResult, actualResult);
    }

    // testing size()

    @Test
    public void testEmptyArraySize() {
        ImmutableArrayList arr = new ImmutableArrayList();

        int expResult = 0;
        int actualResult = arr.size();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);

        int expResult = 4;
        int actualResult = arr.size();
        assertEquals(expResult, actualResult);
    }

    // testing clear()

    @Test
    public void testImmutableClear() {
        String[] s ={"7", "10"};
        ImmutableArrayList arr = new ImmutableArrayList(s);
        ImmutableArrayList arr1 = arr.clear();
        assertNotSame(arr, arr1);
    }


    @Test
    public void testClear() {
        String[] s1 = {"5", "7"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        ImmutableArrayList arr1 = arr.clear();

        String[] expResult = new String[0];
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    // testing isEmpty()

    @Test
    public void testEmptyArrayIsEmpty() {
        ImmutableArrayList arr = new ImmutableArrayList();
        assertTrue(arr.isEmpty());
    }


    @Test
    public void testisEmpty() {
        String[] s1 = {"5", "7"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        assertFalse(arr.isEmpty());
    }

    // testing toArray()

    @Test
    public void testEmptyArrayToArray() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String[] expResult = new String[0];
        Object[] actualResult = arr.toArray();
        assertArrayEquals(expResult, actualResult);
    }


    @Test
    public void testToArray() {
        String[] s1 = {"5", "7"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String[] expResult = {"5", "7"};
        Object[] actualResult = arr.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing toString()

    @Test
    public void testEmptyArrayToString() {
        ImmutableArrayList arr = new ImmutableArrayList();
        String expResult = "\n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementArrayToString() {
        String[] s1 = {"5"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String expResult = "5 \n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }


    @Test
    public void testToString() {
        String[] s1 = {"5", "7", "78"};
        ImmutableArrayList arr = new ImmutableArrayList(s1);
        String expResult = "5 7 78 \n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }
}
