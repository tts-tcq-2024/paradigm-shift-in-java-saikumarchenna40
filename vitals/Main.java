package vitals;

public class Main {
   static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
	   System.out.println("Received Temperature: " + temperature);
	   System.out.println("Received SoC: " + soc);
	   System.out.println("Received ChargeRate: " + chargeRate);
    return isWithinRange(temperature, 0, 45) && isWithinRange(soc, 20, 80) && isChargeRateValid(chargeRate);
}

static boolean isWithinRange(float value, float min, float max) {
    return value >= min && value <= max;
}

static boolean isChargeRateValid(float chargeRate) {
    return chargeRate <= 0.8;
}
	
    public static void main(String[] args) {
        assert batteryIsOk(25, 70, 0.7f) == true;
        assert batteryIsOk(20, 81, 0.0f) == false;
        assert batteryIsOk(20, 60, 10.0f) == false;
        assert batteryIsOk(46, 19, 0.8f) == false;
    }
}
