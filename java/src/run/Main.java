package run;
import  Collection.ReCollection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;



public class Main {
    public static void main(String[]args){
        ReCollection<Integer> cols=new ReCollection();
        int numberOfOne=0;
        for(int i=0;i<50;++i){
            int temp=(int)(Math.random()*2)+1;
            cols.add(temp);
            if(temp == 2)
//                number:13502285507
                numberOfOne++;
        }
    }
}


