public class BubbleSorterRunner{

	public static void main(String [] args){
	
		int [] arrayOf = {9,23,45,2,34,56,12,78,11,74,58};
		BubbleSorter sortM = new BubbleSorter(arrayOf);
		sortM.sort();
		sortM.outPutIt();		
		
	}

}
