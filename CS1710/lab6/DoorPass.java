import java.util.*;

public class DoorPass{

	public static void main (String [] args){
			
		Door [] doorPuzzle = new Door[101];
		doorPuzzle[0] = null;

		for( int iDoor = 1; iDoor <= 100; iDoor++)
			doorPuzzle[iDoor] = new Door("closed", iDoor);

		for(int pass = 1; pass <=100; pass++){
			for(int i = 1; pass*i <=100; i++){
				if (doorPuzzle[pass*i].isOpen())
					doorPuzzle[pass*i].close();
				else
					doorPuzzle[pass*i].open();
			}
		}
		for(int index = 1; index<=100; index++)
			System.out.println(doorPuzzle[index].toString());
	}

}
