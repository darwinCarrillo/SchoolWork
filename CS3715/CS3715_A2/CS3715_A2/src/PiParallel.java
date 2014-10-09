import static java.lang.System.nanoTime;
import java.util.ArrayList;
import java.util.Random;

/* This class is used to calculate the value of Pi 
 * in a multi threaded manner using the Monte Carlo experiment.
 * Author: Darwin Carrillo
 * Assignment #2
 */

class PiCalc extends Thread
{
    public long simulation;
    public long start,end;
    public long start_T, end_T;
    public int total = 0;
    public Random r = new Random();

    public PiCalc(long start, long end)
    {
        this.start = start;
        this.end = end;
        this.simulation = end - start;
        
    }

    public void run()
    {
        start_T = nanoTime();
        do{
            double x = r.nextDouble();
            double y = r.nextDouble();
            if ( Math.hypot( x, y ) <= 1.0 ) 
            {
                total += 1;
            }
            simulation--;
        }
        while(simulation > 0);
        end_T = nanoTime();
    }

    public long getElapsed(){return end_T - start_T;}
    public int getTotal(){return total;}
    public double getPi(){return 4.0*total/(end-start);}
}
    
public class PiParallel{
    
    public static void main(String[] args) throws InterruptedException
    {
        int simulations = Integer.parseInt(args[0]);
        int thread_AMT = Integer.parseInt(args[1]);
        int interval = simulations/thread_AMT;
        long start_I = 0;
        ArrayList<PiCalc> threads = new ArrayList<>();
        //start time and end time
        long begin, end;
        //Total inside
        int inside = 0;
        
        //Create threads
        for( int i = 0; i < (thread_AMT-1); i++ ) {
            threads.add( new PiCalc(start_I, start_I += interval));
        }
        threads.add(new PiCalc(start_I, simulations));
        
        //Start all threads in thread array
        begin = nanoTime();
        for(PiCalc e : threads){e.start();}
        //Print out threads and wait for them to join
        for(PiCalc e : threads)
        {
            int i = threads.indexOf(e)+1;
            e.join();
            System.out.println("Thread "+i+" time: "+e.getElapsed());
            System.out.println("Thread "+i+" pi value: "+e.getPi());
            inside += e.getTotal();
        }
        end = nanoTime();
        System.out.println("Total Elapsed time: " + (end - begin));
        System.out.println("Pi Value: " + 4.0*inside/simulations);
    }
}
