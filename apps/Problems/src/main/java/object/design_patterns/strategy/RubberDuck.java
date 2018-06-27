package object.design_patterns.strategy;

public class RubberDuck extends Duck {


    protected RubberDuck(String name) {

        super(name);

        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();

    }

}
