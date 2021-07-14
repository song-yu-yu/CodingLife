package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import Collection.ReLinkedList;


public class Main {
    public static void main(String[]args){
        Test3<String> t= new Test3<>();
        System.out.println(t.a);
        System.out.println(t.b);
        t.out();
        System.out.println(t.a);
        System.out.println(t.b);
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
    public Test1 b=new Test1();
    public final Test1  a=b;
    public void out(){
        b=new Test1();
    }

}

