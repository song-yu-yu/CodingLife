package Collection;


import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


/*
 *
 * 没有modCount实现并发的检测
 *
 */
class B{

    public void out(){
        System.out.println(this);
    }
}


public class ReCollection<E> implements Collection<E>{

    private final int INITIAL_SIZE=10;
    private int size=0;
    private int length=0;
    private Object [] elements;
    private final Object[] OriginElements={};
    public ReCollection(){
        elements = OriginElements;
    }
    public void outElements(){
        System.out.println(Arrays.toString(elements)+""+elements.length);
    }
    private class ReIterator implements  Iterator<E>{
        private final ReCollection<E> outer=ReCollection.this;
        private int cursor=-1;

        @Override
        public boolean hasNext() {
            return cursor < outer.length - 1;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {

            return (E)outer.elements[++cursor];
        }
    }
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new ReIterator();
    }

    private void ensureCapacity(int length){
        int oldSize=this.size;
        int newSize=oldSize;
        Object[] newElements=null;
        if(length>=this.size) {
            //开始扩容，扩容的机制，是当前size加上它逻辑右移后的值
            if(elements==OriginElements){
                elements=new Object[INITIAL_SIZE];
                size=INITIAL_SIZE;
                return;
            }
            newSize = this.size + (this.size >> 1);
            newElements = new Object[newSize];
            System.arraycopy(elements,0,newElements,0,oldSize);
            elements=newElements;
            size=newSize;
        }
    }
    @Override
    public boolean add(E e) {
        ensureCapacity(length+1);
        elements[length++]=e;
        return true;
    }
    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void forEach(Consumer<? super E> action) {
        for(int i=0;i<length;++i){
            action.accept((E)elements[i]);
        }
    }

    @Override
    public boolean contains(Object o) {
        if(o instanceof String)
            for (int i = 0; i < length; ++i) {
                if (elements[i].equals(o))
                    return true;
            }
        return false;
    }


    @Override
    public boolean isEmpty() {

        return length==0?true:false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        //变量记录当前检测位置，有多少还在集合中的元素的个数
        int passCount=0;//记录过滤元素个数
        for(int i=0;i<length;++i){
            System.out.println(filter.test((E)elements[i]));
            if(!filter.test((E)elements[i])) {
                //不满足过滤条件，同时前面有满足条件的元素开始修改
                if(passCount>0){
                    elements[i-passCount]=elements[i];
                }
            }
            else {
                passCount++;
                elements[i]=null;
                --length;
            }
        }
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }


    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return elements;
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
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
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        elements= OriginElements;
        size=0;
        length=0;
    }
}

