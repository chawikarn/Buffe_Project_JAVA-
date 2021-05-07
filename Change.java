package buffet;

public class Change {
	private double change ; 
	public  double income;
	public  double money ;
	
	public void calChange(double money,double income) {
	
		this.money = money ;
		this.income = income ;
		
		change = money - income ; 
		
	}
	public double getchange() {
		return change ; 
	}
}
