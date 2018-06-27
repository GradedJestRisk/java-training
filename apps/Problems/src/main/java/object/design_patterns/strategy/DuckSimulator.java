package object.design_patterns.strategy;

public class DuckSimulator {

    public static void main(String[] args) {

        ModelDuck modelDuck = new ModelDuck("Billie");
        modelDuck.fullShow();

        RubberDuck rubberDuck = new RubberDuck("Bob");
        rubberDuck.fullShow();

        MallardDuck mallardDuck = new MallardDuck("Thomas");
        mallardDuck.fullShow();

    }
}
