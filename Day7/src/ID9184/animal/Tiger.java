package ID9184.animal;

import ID9184.edible.Edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger";
    }

    @Override
    public String howtoEat() {
        return "Meat";
    }
}

