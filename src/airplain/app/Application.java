package airplain.app;

import airplain.core.Airplane;
import airplain.subscriber.FrontGear;
import airplain.subscriber.RearGear;

public class Application {
    public static void main(String[] args) {

        Airplane a1 = new Airplane();

        a1.addSubscriber(new FrontGear());
        a1.addSubscriber(new RearGear());

        a1.setBreaks();
        a1.releaseBreaks();

    }
}