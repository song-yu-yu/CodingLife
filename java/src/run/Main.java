package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;


public class Main {
    public static void main(String[]args){
        LinkedList<Integer> l1=new LinkedList<>();
        l1.add(1);
        l1.add(2);
        Iterator<Integer> it1=l1.iterator();
        ListIterator<Integer> it2=l1.listIterator();
        System.out.println(it2.previousIndex());

    }
}



interface In1{
    public void out();
}
interface In2 extends In1{
    public void out();
}
class Test3 implements In2{
    public void print(){}

    @Override
    public void out() {

    }
}

