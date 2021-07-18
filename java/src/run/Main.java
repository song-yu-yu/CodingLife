package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Main {
    public static void main(String[]args){
        LinkedList<String>list=new LinkedList<>();
        list.add("1");
        list.add("2");
        list.forEach(System.out::println);
        ListIterator<String> iter=list.listIterator(1);

    }
}




class Test<T>{
    public T out(T a) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (T)a.getClass().getConstructor().newInstance();
    };
}
