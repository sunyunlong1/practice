package concurrent;

public class test {
    public static void main(String[] args) {
//        Father father =  new Sun();
//        father.run();
//        father.walk();
//        ((Sun) father).hhh();
//        System.out.println(father.s);
        Sun s = new Sun();
        s.run();
    }
}
class Father{

    public String s = "abc";

    public static void fly(){
        System.out.println("father fly");
    }

    public void run(){
        System.out.println("father run");
    }

    public void walk(){
        System.out.println("father walk");
    }
}
class Sun extends Father{

    public String s = "aa";


    public static void fly(){
        System.out.println("sun fly");
    }

    public void hhh(){
        System.out.println("sun hhh");
    }
}
