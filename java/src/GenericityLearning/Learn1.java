package GenericityLearning;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Learn1{
    public static void main(String[]args){

        Test1 <String>t1=new Test1<String>();
        Test1 <String>t2=new Test1<String>();
        Test1<String>[]t3=(Test1<String>[])new Test1<?>[10];
        Object []obj=t3;
        obj[0]=new Test1<Integer>();
        System.out.println(obj[0].hashCode());
        t3[0].out("123a");
        System.out.println(t3[0].hashCode());

    }
}



class Test1<T>{
    public void out(T t){
        System.out.println(t.getClass().getSimpleName());
    }
    public Test1(){

    }
}

class Comparing<T>{

}