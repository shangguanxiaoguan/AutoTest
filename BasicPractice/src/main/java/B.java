public class B  extends ExtendsClass {
    static {
        System.out.println("a");
    }
    public void b(){
        System.out.println("b");
    }


    public static void main(String[] args){
        ExtendsClass a = new B();
        a = new B();

    }

}
