package com.com.task19;

public class IntListA implements IntList {

    int size = 10;
    int[] arr = new int[size];
    int top = 0;

    @Override
    public void add(int i) {
        if (top == (size - 1)) {
            int[] newArr = new int[size * 2];
            System.arraycopy(arr, 0, newArr, 0, top + 1);
            arr = newArr;
        }
        top++;
        arr[top] = i;

    }

    @Override
    public void insert(int index, int value) {
        if (index >= 0) {
            top++;
            int in = arr.length - 1;
            for (int i = in; i >= index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
        }
    }

    @Override
    public void set(int index, int value) {
        if (index >= 0) {
            arr[index] = value;
        }
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public int capacity() {
        return size;
    }

    @Override
    public int getByIndex(int index) {
        if (index >= 0) {
            return arr[index];
        }
        return 0;
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
        if (index >= 0) {
            int in = top;
            for (int i = index; i <= in; i++) {
                arr[i] = arr[i + 1];
            }
            top--;
        }
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && toIndex <= top) {
            IntList subList = new IntListA();
            int inInd = fromIndex + (toIndex - fromIndex);
            for (int i = fromIndex; i <= inInd; i++) {
                subList.add(arr[i]);
            }
            return subList;
        }
        return null;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[top + 1];
        System.arraycopy(this.arr, 0, arr, 0, arr.length);
        return arr;
    }
}
