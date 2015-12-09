package big_xplosion.msu.core.helper;

public class MathHelper {

	public static int clamp(int n, int min, int max) {
		return n < min ? min : n > max ? max : n;
	}

	public static double clamp(double n, double min, double max) {
		return n < min ? min : n > max ? max : n;
	}
}
