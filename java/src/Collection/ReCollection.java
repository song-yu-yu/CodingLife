package Collection;


import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


/*
 *
 * 没有实现并发的监控
 *
 */

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

    //返回集合中元素的个数
    @Override
    public int size() {
        return length;
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
        int oldLength=length;
        for(int i=0;i<oldLength;++i){
            if(!filter.test((E)elements[i])) {
                //不满足过滤条件，同时前面有满足条件的元素开始修改
                if(passCount>0){
                    elements[i-passCount]=elements[i];
                    elements[i]=null;//让虚拟机释放资源
                }
            }
            else {
                passCount++;
                elements[i]=null;//标记为null虚拟机释放资源
                --length;
            }
        }
        return false;
    }
    /*
     *返回集合的对象数组
     */
    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements,length);
    }

    /*
     *将集合中的元素放到参数 a 中，如果elements长度比a大，返回一个新的数组，如果比a小，将elements中的所有元素拷贝进去
     */

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if(a.length<length)
            return (T[])Arrays.copyOf(elements,length,a.getClass());
        System.arraycopy(a,0,elements,0,length);
        if(a.length>length)
            a[length]=null;
        return a;
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


    @Override
    public boolean remove(Object o) {
        return removeIf(o::equals);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        Iterator<?> it=c.iterator();
        if(length<c.size()) return false;
        if(length==0)return true;
        while(it.hasNext()){
            if(!contains(it.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        if(c==null)
            return false;
        c.forEach(a->add(a));
        return false;
    }

    //求差集
    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        //利用removeIf的Predicate接口
        if(c.size()==0) return false;
        if(size()==0) return false;
        return removeIf(c::contains);
    }


    //求交集
    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        if(c.size()==0){
            elements=OriginElements;
            size=0;
            length=0;
            return true;
        }
        if(length==0){
            return false;
        }
        //传递一个不包含为真的lambda表达式
        return removeIf(e->!c.contains(e));

    }


    //length小于size的时候可以将数组的存储空间缩小至实际存储元素的占有空间，实际上是创建新的数组并且移动元素
    public void minimizeSize(){
        if(length<size){
            elements=length==0?OriginElements:Arrays.copyOf(elements,length);
        }
    }

    @Override
    public void clear() {
        for(int i=0;i<elements.length;--i){
            elements[i]=null;
        }
        elements= OriginElements;
        size=0;
        length=0;
    }
}

