package airplain.subscriber;

import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Gear extends Subscriber {

    public Gear(int id) {
        super(id);
    }

    private List<Object> wheels = new ArrayList<Object>();

    @Subscribe
    public void receive(ReleaseBreakEvent ev) {

    }

    @Subscribe
    public void receive(SetBreakEvent ev) {

    }

}
