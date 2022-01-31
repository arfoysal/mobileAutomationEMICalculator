package utilities;

public class Utilities {
	public long texttoRoundInteger(String valueString) {
		valueString = valueString.replace(",", "");
		double value = Double.parseDouble(valueString);
		long actualRoundValue = (long) Math.round(value);
		return actualRoundValue;
	}

}
