package Day1;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;



/*
 *
 * 没有modCount实现并发的检测
 *
 */
public class A {
    public static void main(String[]args){

        ReCollection<String> re=new ReCollection<>();
        for(int i=1;i<3;++i){
            re.add("ss");
        }

        Iterator<String> it=re.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        re.forEach((a)->{a=a+"ads";});
        re.forEach(System.out::println);
        System.out.println(re.contains(1));
        "12".equals(1);
        Object obj=new Integer(1);
        Object obj1="sd";
        String num=(String) obj;
        System.out.println(num);

    }
}

class ReCollection<E> implements Collection<E>{

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
        if(length>this.size) {
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
        int passCount=0;
        int lastPassPosition=-1;

        int lastNotpassPosition=-1;
        for(int i=0;i<length;++i){
            //不满足过滤条件，同时前面checkedNotpassCount大于0，执行移动操作，i继续向后移动
            if(!filter.test((E)elements[i])){
                //如果前面的
                if(passCount>0){
                    lastNotpassPosition=i;
                    while(filter.test((E)elements[i++])){

                    }
                }
            }else{
                lastPassPosition=i;
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

