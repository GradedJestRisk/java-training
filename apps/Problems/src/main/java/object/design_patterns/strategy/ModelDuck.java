package object.design_patterns.strategy;

public class ModelDuck extends Duck {


    protected ModelDuck(String name) {

        super(name);

        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();

    }

}
