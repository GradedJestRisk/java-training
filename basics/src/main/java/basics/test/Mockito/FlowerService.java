package basics.test.Mockito;

import java.util.List;

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
