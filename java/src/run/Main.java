package run;
import  Collection.ReCollection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;



public class Main {
    public static void main(String[]args){
        ReCollection<Integer> cols=new ReCollection<Integer>();
        for(int i=0;i<50;++i){
            int temp=(int)(Math.random()*4)+1;
            cols.add(temp);
        }
        ReCollection<Integer> cols1=new ReCollection<Integer>();
        cols1.add(3);
//        cols.removeAll(cols1);
        cols.retainAll(cols1);
        cols.forEach(System.out::println);
    }
}


