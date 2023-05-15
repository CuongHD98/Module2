package ID9184.animal;

import ID9184.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken";
    }

    @Override
    public String howtoEat() {
        return "Vegetable";
    }
}
