public class Wheel {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isBrakeSet = false;

    private static Wheel instance = new Wheel();

    public static Wheel getInstance() {
        return instance;
    }

    public Port port;

    private Wheel() {
        port = new Port();
    }

    public String getVersion() {
        return "Aweseom Wheel One - King Edition";
    }

    public class Port implements IWheel {

        public boolean setBrake() {
            return innerSetBreak();
        }

        public boolean releaseBreak() {
            return innerReleaseBreak();
        }

    }

    private boolean innerSetBreak() {
        if(isBrakeSet == false){
            isBrakeSet = true;
            return true;
        }
        return false;
    }

    private boolean innerReleaseBreak() {
        if(isBrakeSet == true){
            isBrakeSet = false;
            return true;
        }
        return false;
    }
}