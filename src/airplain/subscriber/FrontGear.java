package airplain.subscriber;

import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class FrontGear extends Gear {

    public FrontGear() {
        super(1);
    }

}
