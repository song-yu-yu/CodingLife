package Collection;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/*
 * java类库中实现链表的类是，LinkedList，作为学习，LinkedList简易的实现。
 * List接口继承Collection接口，，
 */
public class ReLinkedList <E>implements List<E>{

    /*
     * 链表的实现来自于内部类的对象引用。外部类看作为内部链表的封装
     */
    private int size=0;

    private class Node<E>{
        private int index=-1;
        private Node<E> nextElement=null;
        private Node<E> previousElement=null;

    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
