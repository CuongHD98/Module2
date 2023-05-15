import java.math.BigInteger;
import java.util.ArrayList;

public class Demo {
    Hair hair = new Hair(){
        @Override
        public String fly(){
            return "Flying";
        }
    };

    public static void main(String[] args) {
        John john1 = new John();
        John john2 = new John();

        System.out.println(john1.equals(john2));
        System.out.println(new Integer(5).compareTo(new Integer(5)));
        System.out.println(new String("ABC").compareTo(new String("ABB")));

        ArrayList<Double> list1 = new ArrayList<>();

        Animal animal = new Chicken();

        eat(animal);

        animal = new Duck();

        eat(animal);

    }

    public static void eat(Animal animal) {

        animal.howToEat();

    }



}
abstract class Body{
    private String text;
    abstract double getDoText();
    abstract int getIndex();

    public boolean checkID(){
        boolean check = false;
        return check;
    }
}

class John extends Body{
    @Override
    public double getDoText(){
        return 4;
    }
    public int getIndex(){
        return 1;
    }

}

interface Hair{
    String fly();

}
interface A{

}
interface B {

}
interface C extends A,B{

}

abstract class Animal {

    public abstract String howToEat();

}
class Chicken extends Animal {

    @Override

    public String howToEat() {

        return "Fry it";

    }

}

class Duck extends Animal {

    @Override

    public String howToEat() {

        return "Roast it";

    }

}