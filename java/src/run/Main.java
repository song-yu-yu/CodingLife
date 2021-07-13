package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Main {
    public static void main(String[]args){
        Test1 t1=new Test1();
        Test2 t2=new Test2();
        Test1 t3=t2;
        LinkedList<String> l=new LinkedList<>();
        l.add("sdfsdf");
        l.<Integer>toArray(new Integer[3]);

    }
}



interface In1{
    public void out();
}
interface In2 extends In1{
    public void out();
}
class Test1{

}
class Test2 extends Test1{

}

class Test3<T>{
    public static class c {
        int a=1;
    }
    public class d{int a=1;}


}

