public class Switch{
    static int f(int i){
        int x;

        if ( i >= 2 && i <= 4 ){ 
            x = 100;
        } else if ( i == 10 || i == 20 ){ 
            x = 50;
        } else if ( i == 100 ){ 
            x = 25;
        } else { 
            x = 15;
        }
        return x;
    }
}

