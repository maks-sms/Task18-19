package com.com.task19;

public class IntListA implements IntList {

    private int size = 10;
    private int[] arr = new int[size];
    private int top = 0;

    @Override
    public void add(int i) {
        if (top >= arr.length) {
            increaseArr();
        }
        arr[top] = i;
        top++;

    }

    @Override
    public void insert(int index, int value) {
        if (top + 1 >= arr.length) {
            increaseArr();
        }
        System.arraycopy(arr, index, arr, index + 1, arr.length - 1 - index);
        arr[index] = value;
        top++;
    }

    @Override
    public void set(int index, int value) {
        arr[index] = value;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public int capacity() {
        return arr.length;
    }

    @Override
    public int getByIndex(int index) {
        return arr[index];
    }

    @Override
    public Integer getIndexByValue(int value) {
        int index = 0;
        for (int i = 0; i <= top; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return index;
    }

    @Override
    public boolean contains(int value) {
        boolean contain = false;
        for (int i : arr) {
            if (arr[i] == value) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    @Override
    public void removeValue(int value) {
        removeByIndex(getIndexByValue(value));
    }

    @Override
    public void removeByIndex(int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == index) {
                int[] temporaryArray = new int[arr.length - 1];
                System.arraycopy(arr, 0, temporaryArray, 0, i);
                System.arraycopy(arr, i + 1, temporaryArray, i, temporaryArray.length - i);
                arr = temporaryArray;
                top--;
            }
        }
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList subList = new IntListA();
        int inInd = fromIndex + (toIndex - fromIndex);

        for (int i = fromIndex; i < inInd; i++) {
            subList.add(arr[i]);
        }
        return subList;

    }

    @Override
    public int[] toArray() {
        int[] arr = new int[top];
        System.arraycopy(this.arr, 0, arr, 0, arr.length);
        return arr;
    }

    public void increaseArr() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

}
