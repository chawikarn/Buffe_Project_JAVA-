package buffet;

public class Calculator {

	private double bonusScore ; 
	public  double income;
	public  String cus_class;
	
	public void calBonus(String cus_class,double income) {
		
	
		if (cus_class.equals("General")) {
			bonusScore =  0 ;
		}
		
		if (cus_class.equals ("Silver")) {
			this.income = income;
			bonusScore =  income*10/100 ;
		}
		
		if (cus_class.equals ("Gold")) {
			this.income = income;
			bonusScore =  12 ;
		}
		
	}
	public double getBonus() {
		return bonusScore ; 
	}
}
