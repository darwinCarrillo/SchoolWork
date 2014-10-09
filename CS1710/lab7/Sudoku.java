public class Sudoku
{
   private String[][] x;
   private final int SIZE = 9;
   
   public Sudoku(String s)
   {
      int k = 0;
      x = new String[SIZE][SIZE];
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
         {
            x[i][j] = s.substring(k ,k + 1);
            k++;
         }
      }
   }
   public String toString()
   {
      String temp = "";
      for (int i = 0; i < SIZE; i++)
      {
         if ((i == 3) || (i == 6))
         {
            temp = temp + "=================\n";
         }
         for (int j = 0; j < SIZE; j++)
         {
            if ((j == 3) || (j == 6))
            {
               temp = temp + " || ";
            }
            temp = temp + x[i][j];
         }
         temp = temp + "\n";
      }
      return temp;
   }

	/*check rows */
	public boolean rowIsLatin(int z){
		boolean [] rowTrue = new boolean[9];
		for(int i = 0; i < 9; i++){		
			if(rowTrue[Integer.parseInt(x[z][i])] == true)
				return false;
			else
				rowTrue[Integer.parseInt(x[z][i])] = true;
		}
		return true; 
	}

	public boolean rowsAreLatin(){
		for(int x = 0; x < 9; x++){
			if(!rowIsLatin(x))
				return false;
		}
		return true;
	}/*check rows*/

	/* check columns*/
	public boolean columnIsLatin(int z){
		boolean [] colTrue = new boolean[9];
		for(int i = 0; i < 9; i++){
			if(colTrue[Integer.parseInt(x[z][i])] == true)
				return false;
			else
				colTrue[Integer.parseInt(x[z][i])] = true;
		}
		return true; 			
	}

	public boolean columnsAreTrue(){
		for(int x = 0; x < 9; x++){
			if(!columnIsLatin(x))
				return false;
		}
		return true;
	}/* check column */

	/* check the sub square */
public boolean goodSubsquares()
   {
      boolean result = true;  // Assume subsquares are latin
      for(int i=0; i < SIZE/3; i++)
      {
         for(int j=0; j < SIZE/3; j++)
         {
            result = result && goodSubsquare(i,j);  // Make sure each subsquare is latin
         }
      }
      return result;
   }

   public boolean goodSubsquare(int i, int j)
   {
      boolean[] found = new boolean[SIZE];
      // We have a 3 x 3 arrangement of subsquares
      // Multiplying each subscript by 3 converts to the original array subscripts
      for (int p = i * 3, rowEnd = p + 3; p < rowEnd; p++)
      {
         for (int q = j * 3, colEnd = q + 3; q < colEnd; q++)
         {
            // Numbers run from 1 to 9, Array indexes 0 to 8, so subtract 1
            int k = Integer.parseInt(x[p][q]) - 1;

            found[k] = true;  // found[0] = true means 1 is present, 
                              // found[1] = true means 2 is present,... 
         }
      }
      boolean result = true;  // Assume subsquare has every symbol...
      for (int p = 0; p < SIZE; p++)
      {
         result = result && found[p];  //... unless we detect a missing symbol
      }
      return result;
   }

	/* check the sub square */	

   public boolean isValidSudoku()
   {
      return goodSubsquares() && columnsAreTrue() && rowsAreLatin();
   }
}
