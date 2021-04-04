package course.homeworks.hw4;

import course.homeworks.hw3.hash.EffectiveHashcode;

import java.util.*;

/**
 * Class <code>MyArrayList</code> is self made ArrayList with some methods(required as exercise) of original.
 */
public class MyArrayList<E> {

    transient Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[]{};
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
            this.size = capacity;
        } else if (capacity == 0)
            this.array = new Object[]{};
        else
            throw new IllegalArgumentException();
    }

    public MyArrayList(Collection<? extends E> c) {
        if (c.size() != 0) {
            this.array = c.toArray();
            this.size = array.length;
        } else
            this.array = new Object[]{};
    }

    /**
     * Checks specified index if in bounds.
     *
     * @throws IndexOutOfBoundsException if not.
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Increase <code>MyArrayList</code> elements number of elements specified in <code>sizeToAdd</code>
     *
     * @param sizeToAdd number of elements to grow
     * @return resulting array
     */
    private Object[] grow(int sizeToAdd) {
        return Arrays.copyOf(this.array, size + sizeToAdd);
    }

    /**
     * @return the size of the <code>MyArrayList</code>
     */
    int size() {
        return this.size;
    }

    /**
     * Ads the element <code>E element</code> to specified index with shifting to the right of
     * original elements.
     *
     * @param index   position of the list where specified element will be inserted.
     * @param element element to insert
     * @throws IndexOutOfBoundsException if index is less than 0 and bigger than last index of MyArrayList.
     */
    void add(int index, E element) {
        checkIndex(index);
        array = grow(1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        this.size++;
    }

    /**
     * Ads all elements from <code>Collection<? extends E> c</code> to MyArrayList starting at
     * specified index with shifting to the right of original elements.
     *
     * @param index position of the list where specified element will be inserted.
     * @param c     collection to insert
     * @return true on success modifying. False if list haven't changed.
     * @throws IndexOutOfBoundsException if index is less than 0 and bigger than last index of MyArrayList.
     * @throws NullPointerException      if specified collection is null.
     */
    boolean addAll(int index, Collection<? extends E> c) {
        int size;
        if (c == null) throw new NullPointerException();
        checkIndex(index);
        if ((size = c.size()) == 0)
            return false;
        array = grow(size);
        System.arraycopy(array, index, array, index + size, this.size - index);
        System.arraycopy(c.toArray(), 0, array, index, size);
        this.size += size;
        return true;
    }

    /**
     * @param index position to get element.
     * @return element at specified position.
     * @throws IndexOutOfBoundsException if index is less than 0 and bigger than last index of MyArrayList.
     */
    E get(int index) {
        return (E) this.array[index];
    }

    /**
     * Finds first occurrence of <code>Object o</code> in the list.
     * @param o object to find
     * @return index of found element. Otherwise -1.
     */
    int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (array[i] != null && array[i].equals(o))
                return i;
        return (-1);
    }

    /**
     * Finds last occurrence of <code>Object o</code> in the list.
     * @param o object to find
     * @return index of found element. Otherwise -1.
     */
    int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--)
            if (array[i] != null && array[i].equals(o))
                return i;
        return (-1);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     */
    ListIterator<E> listIterator() {
        ListIterator<E> listIterator = new ListIterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }

            @Override
            public E next() {
                if (array[currentIndex + 1] != null)
                    return (E) array[++currentIndex];
                throw new NoSuchElementException();
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex < size && currentIndex != 0 && array[currentIndex - 1] != null;
            }

            @Override
            public E previous() {
                if (currentIndex != 0 && array[currentIndex - 1] != null)
                    return (E) array[--currentIndex];
                throw new NoSuchElementException();
            }

            @Override
            public int nextIndex() {
                return currentIndex + 1;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(currentIndex);
            }

            @Override
            public void set(E e) {
                MyArrayList.this.set(currentIndex, e);
            }

            @Override
            public void add(E e) {
                MyArrayList.this.add(currentIndex, e);
            }
        };
        return listIterator;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified
     * position in the list. The specified index indicates the first element that would be returned by an
     * initial call to next. An initial call to previous would return the element with the specified index
     * minus one.
     */
    ListIterator<E> listIterator(int index) {
        if (index < 0 || index >= size)
            throw new NoSuchElementException();
        ListIterator<E> listIterator = new ListIterator<E>() {
            private int currentIndex = index;

            @Override
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }

            @Override
            public E next() {
                if (array[currentIndex + 1] != null)
                    return (E) array[++currentIndex];
                throw new NoSuchElementException();
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex < size && currentIndex != 0 && array[currentIndex - 1] != null;
            }

            @Override
            public E previous() {
                if (currentIndex != 0 && array[currentIndex - 1] != null)
                    return (E) array[--currentIndex];
                throw new NoSuchElementException();
            }

            @Override
            public int nextIndex() {
                return currentIndex + 1;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(currentIndex);
            }

            @Override
            public void set(E e) {
                MyArrayList.this.set(currentIndex, e);
            }

            @Override
            public void add(E e) {
                MyArrayList.this.add(currentIndex, e);
            }
        };
        return listIterator;
    }

    /**
     * Removes an element at specified position.
     * @param index position to remove.
     * @return removed element.
     * @throws IndexOutOfBoundsException if index is less than 0 and bigger than last index of MyArrayList.
     */
    E remove(int index) {
        checkIndex(index);
        E tmp = (E) this.array[index];
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        array[this.size-- - 1] = null;
        return tmp;
    }

    /**
     * Replaces an element at specified position.
     * @param index position to replace.
     * @param element the elemnt to set at specified position.
     * @return previous element.
     * @throws IndexOutOfBoundsException if index is less than 0 and bigger than last index of MyArrayList.
     */
    E set(int index, E element) {
        checkIndex(index);
        E tmp = (E) this.array[index];
        this.array[index] = element;
        return tmp;
    }

    /**
     * Creates sublist from <code>MyArrayList</code> from position at <code>fromIndex</code> including, to
     * position at <code>toIndex</code> exclusive. If <code>fromIndex</code> and <code>toIndex</code> are equal
     * or <code>fromIndex</code> bigger than <code>toIndex</code>, then creates an empty list.
     * @param fromIndex position to start including.
     * @param toIndex position to end exclusive.
     * @return created ArrayList.
     */
    List<E> sublist(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        int len = toIndex - fromIndex;
        if (len < 0) len = 0;
        Object[] arr = new Object[len];
        System.arraycopy(this.array, fromIndex, arr, 0, len);
        return (List<E>) Arrays.asList(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return new EffectiveHashcode().getHashcode(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
