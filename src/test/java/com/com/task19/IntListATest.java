package com.com.task19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntListATest {

    private IntListA list;

    @BeforeEach
    public void setUp() {
        list = new IntListA();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void emptyList() {
        IntListA emptyList = new IntListA();
        Assertions.assertEquals(0, emptyList.size());
    }

    @Test
    public void checkingIndexes() {
        int[] array = new int[]{1, 2, 3, 4};
        Assertions.assertArrayEquals(list.toArray(), array);
    }

    @Test
    public void deleteByIndex() {
        int i = list.getByIndex(3);
        list.removeByIndex(1);
        int j = list.getByIndex(2);
        Assertions.assertEquals(i, j);
    }

    @Test
    public void wrongIndexElement() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
            list.getByIndex(10));
    }

    @Test
    public void subListMethodReturnSubString() {
        int[] arrayFromSubList = list.subList(0, 2).toArray();
        int[] expectedArray = new int[]{1, 2};
        Assertions.assertArrayEquals(expectedArray, arrayFromSubList);
    }

    @Test
    public void sizeByUserValues() {
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void listCapacity() {
        Assertions.assertEquals(10, list.capacity());
    }

    @Test
    public void listContains() {
        Assertions.assertTrue(list.contains(1));
        Assertions.assertFalse(list.contains(8));
    }

    @Test
    public void listIsNotUpdateByArray() {
        int[] array = list.toArray();
        array[2] = 20;
        Assertions.assertNotEquals(array, list.toArray());
    }

}
