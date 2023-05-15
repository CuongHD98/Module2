public class Demo {
     int count = 0;
    /*se lay bo nho (memory) khi bien instance duoc tao*/

    /*Ket qua thuc hien chuong trinh hien ra 3 so 1 o 3 dong*/
//    Demo() {
//        count++;
//        System.out.println(count);
//    }
//
//    public static void main(String args[]) {
//        Demo c1 = new Demo();
//        Demo c2 = new Demo();
//        Demo c3 = new Demo();
//    }
}

class Test1 {

    static int a;
    static {
        int a = 6;
    }
    static int input() {
        return 5;
    }

    public int idInput() {
        input();
        return 1;
    }

    class B {
        public int outPut(){
            return 5;
        }
    }
    static public class D{

    }

}

class C {
    Test1.B a = new Test1().new B();
    Test1.D v = new Test1.D();
}
