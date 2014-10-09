import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.geom.Ellipse2D;

public class BouncingWithTrap extends Bouncing implements MouseListener {
    private boolean trap = false;

    public BouncingWithTrap() {
        super();
        addMouseListener( this );
    }

    public void mouseClicked( MouseEvent e) {
    }

    public void mousePressed( MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Ellipse2D ball = getBall();
        System.out.println( "trapped: " + trap );
		  if(ball.contains(x,y)){
		  		if(trap == false){
					trap = true;
					stop();
				}
				else{trap = false; start();}	
	     }
    }

    public void mouseReleased( MouseEvent e) {
    }

    public void mouseEntered( MouseEvent e) { } // ignore
    public void mouseExited( MouseEvent e) { } // ignore

    public static void main( String[] args ) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
               /* create frame */
               JFrame frame = new JFrame();

               BouncingWithTrap bouncing = new BouncingWithTrap();
               frame.setSize( bouncing.getPreferredSize() );
               frame.setTitle( bouncing.getClass().getName() );
               frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
               frame.add( bouncing );
               frame.setVisible( true );
            }
        });
    }
}
