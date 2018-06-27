package object.design_patterns.strategy;

public class MallardDuck extends Duck {


    protected MallardDuck(String name) {

        super(name);

        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();

    }

}
