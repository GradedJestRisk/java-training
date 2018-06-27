package object.design_patterns.strategy;

 class FlyNoWay implements FlyBehavior{

     public void fly(){
        System.out.println("I'm not flying at all..");
    }

}
