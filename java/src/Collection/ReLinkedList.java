package Collection;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;


/*
 * java类库中实现链表的类是，LinkedList，作为学习，LinkedList简易的实现。
 * List接口继承Collection接口，，
 */
public class ReLinkedList <E>implements List<E>{

    /*
     * 链表的实现来自于内部类的对象引用。外部类看作为内部链表的封装
     * 实现的是没有头结点的链表
     */
    //节点数量
    private int size=0;

    //链表尾指针
    private Node<E> tail=null;

    //链表头指针
    private Node<E> head=null;
    private class Node<E>{
        private int index=-1;
        E element=null;

        //指向下一个节点
        private Node<E> nextNode=null;

        //指向先驱节点
        private Node<E> previousNode=null;

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


    //需要遍历链表
    @Override
    public boolean contains(Object o) {
        Node<E> t=head;
        if(o==null){
            while(t!=null){
                if(t.element==null) return true;
                t=t.nextNode;
            }
        }else{
            while(t!=null){
                if(o.equals(t.element)) return true;
                t=t.nextNode;
            }
        }
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
        Object [] obj=new Object[size];
        Node<E> t=head;
        int i=0;
        while(t!=null){
            obj[i++]=t.element;
        }
        return obj;
    }

    @Override
    public void forEach(Consumer<? super E> action){
        Node<E> t=head;
        while(t!=null) {
            action.accept(t.element);
            t = t.nextNode;
        }
    }
    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        if(a==null){
            return null;
        }
        if(a.length<size)
            a= (T[])Array.newInstance(a.getClass().getComponentType(),size);
        if(a.length>size)
            a[size]=null;
        Node<E> t=head;
        int i=-1;
        Object [] obj=a;
        while(t!=null)
            obj[++i]=t.element;
        return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> s=new Node<>();
        s.nextNode=null;
        s.element=e;
        if(head==null){
            head=s;
            tail=s;
            s.previousNode=null;
            s.index=0;
            return true;
        }
        s.index=++tail.index;
        s.previousNode=tail;
        tail.nextNode=s;
        tail=s;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(head==null)
            return false;
        o=tail.element;
        tail.element=null;
        if(head==tail){
            head=null;
            tail=null;
            return true;
        }
        tail=tail.previousNode;
        tail.nextNode=null;
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
      for(Node<E>s=head;s!=null;s=s.nextNode){
          if(!c.contains(s)) return false;
      }
      return true;
    }

    //将集合中所有的元素加入到链表
    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        if(head==null)
            return false;
        Iterator < ? extends  E>iter=c.iterator();
        while(iter.hasNext())
            add(iter.next());
        return true;
    }

    //标为index的节点开始加入链表
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        if(c==null)
            return false;
        Node<E>s=new Node();
        Iterator<? extends E> e=c.iterator();

        while(e.hasNext()){
            add(e.next());
        }
        return true;
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
