package osago;

public abstract class Calc {

	protected static double OSAGO;
	
	public double mul(double TB, double KT, double KBM, double KBC, double KO, double KM, double KC) {

		OSAGO = TB*KT*KBM*KBC*KO*KM*KC;
		return OSAGO;
	}
}