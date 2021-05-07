package buffet;

public class PromotionFactory extends Tax{
	protected double total;
	public PromotionFactory() {
		super();
	}
	public Promotion createPromotion(String pro) {
		if(pro.equals("General")){
			return (new General());
		}else if(pro.equals("Silver")){
			return (new General());
		}else{
			return (new Gold());
		}
	}
	public double calTax(double Sum){
		total = Sum*tax;
		return total;
	}
}
