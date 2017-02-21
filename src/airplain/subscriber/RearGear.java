package airplain.subscriber;

import airplain.core.Component;
import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import com.google.common.eventbus.Subscribe;

public class RearGear extends Gear {
    public RearGear() {
        super(2);

        wheels.add(new Component("Wheel"));
        wheels.add(new Component("Wheel"));
        wheels.add(new Component("Wheel"));
        wheels.add(new Component("Wheel"));
    }
}
