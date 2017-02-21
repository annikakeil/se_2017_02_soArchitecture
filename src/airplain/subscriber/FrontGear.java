package airplain.subscriber;

import airplain.core.Component;
import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import com.google.common.eventbus.Subscribe;

public class FrontGear extends Gear {

    public FrontGear() {
        super(1);

        wheels.add(new Component("Wheel"));
        wheels.add(new Component("Wheel"));
    }

}
