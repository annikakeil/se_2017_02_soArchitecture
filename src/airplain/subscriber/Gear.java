package airplain.subscriber;

import airplain.core.Component;
import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Gear extends Subscriber {

    public Gear(int id) {
        super(id);
    }

    protected List<Component> wheels = new ArrayList<Component>();

    @Subscribe
    public void receive(ReleaseBreakEvent ev) {
        System.out.println("Recv Event[ReleaseBreakEvent]: " + getClass().getSimpleName());
        for (Component component : wheels) {
            component.releaseBreak();
        }
    }

    @Subscribe
    public void receive(SetBreakEvent ev) {
        System.out.println("Recv Event[SetBreakEvent]: " + getClass().getSimpleName());
        for (Component component : wheels) {
            component.setBrake();
        }
    }

}
