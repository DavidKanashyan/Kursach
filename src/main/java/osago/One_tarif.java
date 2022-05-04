package osago;

public class One_tarif extends Calc {

	private static double sum=0;
	
	public One_tarif(double TB, double KT, double KBM, double KBC, double KO, double KM, double KC) {
		sum=mul(TB, KT, KBM, KBC, KO, KM, KC);
	}
	
	public static double getSum() {
		return sum;
	}
}