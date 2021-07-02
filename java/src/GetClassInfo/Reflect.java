package GetClassInfo;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
public class Reflect {
    public static void classInfo(Class c)throws ClassNotFoundException{
        int  classModType = c.getModifiers();
        System.out.println(Modifier.toString(classModType));

    }
}
