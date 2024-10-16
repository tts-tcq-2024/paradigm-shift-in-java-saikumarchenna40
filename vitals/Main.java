package vitals;

public class Main {
   static boolean batteryIsOk(float temperature, float soc, float chargeRate, int tolerencePercent) {
	   System.out.println("Received Temperature: " + temperature);
	   System.out.println("Received SoC: " + soc);
	   System.out.println("Received ChargeRate: " + chargeRate);
    return isWithinRange(temperature, 0, 45, true, tolerencePercent) && isWithinRange(soc, 20, 80, true, tolerencePercent) && isChargeRateValid(chargeRate, true, tolerencePercent);
}

static boolean isWithinRange(float value, float min, float max, boolean isWarningRequired, int tolerencePercent) {
	if (isWarningRequired) {
		validateTolerance(value, min, max, tolerencePercent);
	}
    return value >= min && value <= max;
}
	
static void validateTolerance(float value, float min, float max, int tolerencePercent) {
	float tolerance = max * (tolerencePercent * 1f);
	checkLowerLimit(value, min, tolerance);
        checkUpperLimit(value, max, tolerance);
}

static void checkLowerLimit(float value, float min, float tolerance) {
    if (value >= min && value <= (min + tolerance)) {
        System.out.println("Warning: Approaching discharge");
    }
}

static void checkUpperLimit(float value, float max, float tolerance) {
    if (value >= (max - tolerance) && value <= max) {
        System.out.println("Warning: Approaching charge-peak");
    }
}
	
static boolean isChargeRateValid(float chargeRate, boolean isWarningRequired, int tolerencePercent) {
	if (isWarningRequired) {
		validateTolerance(chargeRate, Float.MIN_VALUE, 0.8f, tolerencePercent);
	}
    return chargeRate <= 0.8;
}
	
    public static void main(String[] args) {
        assert batteryIsOk(25, 70, 0.7f, 5) == true;
        assert batteryIsOk(20, 81, 0.0f, 5) == false;
        assert batteryIsOk(20, 60, 10.0f, 5) == false;
        assert batteryIsOk(46, 19, 0.8f, 5) == false;
    }
}
