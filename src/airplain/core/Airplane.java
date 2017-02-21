package airplain.core;

import airplain.events.ReleaseBreakEvent;
import airplain.events.SetBreakEvent;
import airplain.subscriber.Subscriber;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Airplane {

    private EventBus eventBus = new EventBus("AirplaneBus");

    public void addSubscriber(Subscriber subscriber){
            eventBus.register(subscriber);
    }

    public void setBreaks() {
        debug(SetBreakEvent.class.getSimpleName());
        eventBus.post(new SetBreakEvent(1, "Bremsen drücken"));
    }

    public void releaseBreaks() {
        debug(ReleaseBreakEvent.class.getSimpleName());
        eventBus.post(new ReleaseBreakEvent(1, "Bremsen loslassen"));
    }

    private void debug(String name) {
        System.out.println("Send Event[" + name + "]: " + getClass().getSimpleName());
    }
}
