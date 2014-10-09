import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class StopWatch extends JPanel {
    /*
     * Configuration constants.
     */
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;

    private Timer tickTimer;

    private JButton stopButton;
    private JButton startButton;
	private JButton resetButton;	 
    private JLabel msgLabel;
    private Font theFont = new Font("monospaced", Font.BOLD, 50);

    private double clicked;

    public StopWatch() {
        super( new GridLayout(2,1, 5, 0) );
        setPreferredSize( new Dimension( WINDOW_WIDTH, WINDOW_HEIGHT ) );

        // define the stop button and its presentation
        stopButton = new JButton( "Stop" );
        stopButton.setFont( theFont );
        stopButton.setForeground( Color.BLACK );
        stopButton.setBackground( Color.RED );

        // define the start button and its presentation
        startButton = new JButton( "Start" );
        startButton.setFont( theFont );
        startButton.setForeground( Color.BLACK );
        startButton.setBackground( Color.GREEN );

		// define reset Button
		resetButton = new JButton("Reset");
		resetButton.setFont(theFont);
		resetButton.setForeground( Color.BLACK);
		resetButton.setBackground( Color.yellow);

        JPanel buttons = new JPanel( new GridLayout(1, 2) );
        buttons.add( stopButton );
        buttons.add( startButton );
		buttons.add( resetButton );
        add(  buttons );

        // define the label, below the buttons
        msgLabel = new JLabel( "0" );
        msgLabel.setHorizontalAlignment( SwingConstants.CENTER );
        msgLabel.setFont( theFont );
        add( msgLabel );

        // 1000ms timer, and Inner class handling 
        tickTimer = new Timer( 100,  new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {
                // XXX
                System.out.println("tick");
            }
        });
        // XXX start the time, the timer can be stopped with tickTimer.stop()
        tickTimer.start();

        // Inner class for handling stop button presses
        stopButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {
                // XXX
                clicked--;
                msgLabel.setText( String.valueOf( clicked ) );
            }
        });

        // Inner class for handling start button presses
        startButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {
                // XXX
                clicked += clicked + 1;
                msgLabel.setText( String.valueOf( clicked ) );
            }
        });
    }

    public static void runApplication( final JPanel app ) {
        EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    /* create frame */
                    JFrame frame = new JFrame();
                    frame.setSize( app.getPreferredSize() );
                    frame.setTitle( app.getClass().getName() );
                    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    frame.add( app );
                    frame.setVisible( true );
                }
            } );
    }

    /*
     * Create the frame to show the application
     */
    public static void main( String[] args ) {
        StopWatch application = new StopWatch();
        runApplication( application );
    }
}
