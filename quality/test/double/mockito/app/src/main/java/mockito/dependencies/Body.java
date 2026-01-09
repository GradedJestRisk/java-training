package mockito.dependencies;

public class Body {
    private Foot leftFoot;
    private Foot rightFoot;

    public Body() {
        this.leftFoot = new Foot();
        this.rightFoot = new Foot();
    }

    public void move(){
        this.leftFoot.forward("1");
    }
}