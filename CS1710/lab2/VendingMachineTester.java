public class VendingMachineTester{

	public static void main(String [] args){
		VendingMachine machine = new VendingMachine(39, 10);
		System.out.println(machine.getCanCount());
		System.out.println(machine.getTokenCount());
		machine.fillUpCans(10);
		machine.insertToken();
		machine.insertToken();
      		System.out.print("Token count: ");
      		System.out.println(machine.getTokenCount());
      		System.out.println("Expected:2");
      		System.out.print("Can count: ");
      		System.out.println(machine.getCanCount()); 
      		System.out.println("Expected: 8");
	} 
}
