package PracticeImplement;

import jdk.jfr.consumer.RecordedClass;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;




public class ReCollection<T> implements Collection<T> {
    public static void main(String []args){
        ReCollection<String> strs=new ReCollection<String>(){{add("宋");add("雨");}};
        Iterator<String> it=strs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    private Object[] elements;
    private final int INITIAL_SIZE=10;
    private int size;
    private final Object[] INITIAL_ELEMENTS={};
    private int haveItem;
    public ReCollection(){//默认构造函数，初始属性
        elements=INITIAL_ELEMENTS;
        size=0;
        haveItem=0;

    }
    private class ReIterator<T> implements Iterator<T>{
        private int index=-1;
        private Object [] elements=ReCollection.this.elements;
        @Override
        public boolean hasNext() {
            if(index>=ReCollection.this.haveItem-1){
                return false;
            }
            return true;
        }
        @Override
        public T next() {
            if(hasNext()){

                return (T)ReCollection.this.elements[index++];
            }else{
                return null;
            }

        }
    }

    private void capacityCheck(int num){
        if(num>=size){
            if(INITIAL_ELEMENTS==elements){
                elements=new Object[INITIAL_SIZE];
                size=INITIAL_SIZE;
            }else{
                //扩容开始

                    int oldSize=size;
                    int newSize=oldSize+(oldSize>>1);
                    Object []newElements=new Object[newSize];
                    System.arraycopy(elements,0,newElements,0,oldSize);
            }
        }
    }

    @Override
    public boolean add(T t) {
        capacityCheck(haveItem+1);
        elements[haveItem++]=t;
        return true;
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
    public Iterator<T> iterator() {
        return this.new ReIterator<T>();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
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
    public boolean addAll(@NotNull Collection<? extends T> c) {
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
}
