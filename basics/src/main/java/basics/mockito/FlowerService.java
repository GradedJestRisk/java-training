package basics.mockito;

import java.util.List;

enum Flower {
    ROSE, DAISY
}

public class FlowerService {

    FlowerService() {
    }

    public String wrap(String something) {
        return "A parcel of " + something;
    }

    public String wrap(List<Flower> flowers) {
        return "A bouquet of " + flowers;
    }

    public String wrap() {
        return "Nothing";
    }
}
