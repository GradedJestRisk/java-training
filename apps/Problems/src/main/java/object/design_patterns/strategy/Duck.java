package object.design_patterns.strategy;

public  class Duck {

    protected String name;

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(String name) {
        this.name = name;
    }

    protected void performQuack(){
        quackBehavior.quack();
    }

    protected void performFly(){
        flyBehavior.fly();
    }

    protected void entroduce(){
        System.out.println("Hello");
        System.out.println("My name is " + name + ", I'm a " + this.getClass().getSimpleName() );
    }

    protected void goodbye(){
        System.out.println("Good-bye.. \n");
    }


    protected void fullShow(){
        entroduce();
        performFly();
        performQuack();
        goodbye();
    }

}
