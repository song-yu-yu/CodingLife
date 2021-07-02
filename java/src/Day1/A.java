package Day1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;

public class A {
    public static void main(String[]args){
//        Test.out(OtherTest::out,new OtherTest(),"ssd");
//
//        GetMax<OtherTest> t=(ot,str)->{System.out.println(str);};
//        t.out(new OtherTest(),"sdfsd");
        Arrays.sort(new String[]{"sdf","gfd"},String::compareTo);
        Number [] numbers=new Number[]{new Number(1),new Number(2)};
        Test.getMax(numbers,Number::compare);
    }
}

interface GetMax<T>{
    public void out(T t,String str);
}

class Test{
    public static void out(GetMax<? super OtherTest> r,OtherTest o,String str){
        r.out(o,str);
    }
    public static  void getMax(@NotNull Number [] numbers,@Nullable OutMax<? super Number> r){
        Number maxValue=new Number(Integer.MIN_VALUE);
        for(int i=0;i<numbers.length;++i){
            if(r.compare(numbers[i],maxValue)){
                maxValue=numbers[i];
            }
        }
        System.out.println(maxValue.get());
    }
}

class OtherTest{
    public void out(String str){
        System.out.println(str);
    }
}

interface OutMax<T>{
    public boolean compare(T r1,T r2);
}

class Number{
    private int number=1;
    public int get(){
        return this.number;
    }
    public boolean compare(Number number){
        return this.number>number.number?true:false;

    }
    public Number(int number){
        this.number=number;
    }
}