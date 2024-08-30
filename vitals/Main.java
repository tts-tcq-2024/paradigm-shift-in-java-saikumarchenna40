package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return (validateTemperature(temperature) && validateSoc(soc) && validateChargeRate(chargeRate));
    }

	static boolean validateTemperature(float temperature) {
		boolean isValidTemp = false;
		if (temperature >=0 && temperature <= 45) {
			isValidTemp = true;
		} else {
			System.out.println("Temperature is out of range!");
		}
		return isValidTemp;
		
	}
	
	static boolean validateSoc(float soc) {
		boolean isValidSoc = false;
		if (soc >= 20 && soc <= 80) {
			isValidSoc = true;
		} else {
			System.out.println("State of Charge is out of range!");
		}
		return isValidSoc;
	}
	
	static boolean validateChargeRate(float chargeRate) {
		boolean isValidChargeRate = false;
		if (chargeRate <= 0.8) {
			isValidChargeRate = true;
		} else {
			 System.out.println("Charge Rate is out of range!");
		}
		return isValidChargeRate;
	}
	
    public static void main(String[] args) {
        assert batteryIsOk(25, 70, 0.7f) == true;
        assert batteryIsOk(20, 81, 0.0f) == false;
        assert batteryIsOk(20, 60, 10.0f) == false;
        assert batteryIsOk(46, 19, 0.8f) == false;
    }
}
