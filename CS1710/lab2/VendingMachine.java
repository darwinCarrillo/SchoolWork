public class VendingMachine{

	public int cans;
	public int tokens;
	
	public VendingMachine(){
		this.cans = 10;
		tokens = 0;
	}

	public VendingMachine(int cans){
		this.cans = cans;
		tokens = 0;
	}

	public VendingMachine(int cans, int tokens){
		this.cans = cans;
		this.tokens = tokens;
	}		
		

	public void fillUpCans(int cans){
		this.cans = this.cans + cans;
		}

	public void insertToken(){
		if (cans!= 0){
			this.cans--;
			}
		this.tokens++;
	}

	public int getCanCount(){
		return cans;
	}

	public int getTokenCount(){
		return tokens;	
	}
}
