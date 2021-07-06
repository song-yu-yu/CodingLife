package run;
import  Collection.ReCollection;
import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.function.Predicate;


public class Main {
    public static void main(String[]args){
        ReCollection<Integer> cols=new ReCollection<Integer>();
        ReCollection<Integer> cols1=new ReCollection<Integer>();
        cols.add(1);
        cols1.add(2);
//        cols.out();
        cols1.addAll(cols1);
//        cols1.forEach(System.out::println);
    }
}

class test{
    public void out(){
        Predicate<Integer> pre=a->{System.out.println(this); this.print();return false;};
        pre.test(1);
    }
    public void print(){
        System.out.println(this);
    }
}


