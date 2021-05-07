package buffet;

public abstract class Promotion{
	protected double resultS;
	protected double resultD;

	public void calSetResult(double total1) {}
	public void calDrinkResult(double total2) {}
	public double getSetResult() {
		return resultS;
	}
	public double getDrinkResult() {
		return resultD;
	}
}
