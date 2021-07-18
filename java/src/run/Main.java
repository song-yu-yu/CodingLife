package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import Collection.ReLinkedList;


public class Main {
    public static void main(String[]args){

    }
}



class Test<T>{
    public T out(T a) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (T)a.getClass().getConstructor().newInstance();
    };
}

