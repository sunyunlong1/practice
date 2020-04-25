package concurrent;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is  = getClass().getResourceAsStream(filename);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object o=myLoader.loadClass("concurrent.ClassLoaderTest").newInstance();
//        Object o1=myLoader.loadClass("concurrent.ClassLoaderTest").newInstance();
//        System.out.println(o == o1);
        System.out.println(o);
        System.out.println(o.getClass());
        System.out.println(o instanceof concurrent.ClassLoaderTest);
    }
}
