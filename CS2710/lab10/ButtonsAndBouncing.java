import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

public class ButtonsAndBouncing extends JPanel
    implements ActionListener
{
    private Bouncing bouncing;
    private JButton stopButton;
    private JButton startButton;

    public ButtonsAndBouncing() {
       setLayout( new BorderLayout() );

       startButton = new JButton("start");
       startButton.addActionListener( this );
       stopButton = new JButton("stop");
       stopButton.addActionListener( this );

       JPanel p = new JPanel( new GridLayout(1, 2) );
       p.add( startButton );
       p.add( stopButton );
       add( p, BorderLayout.EAST );

       bouncing = new Bouncing();
       add( bouncing, BorderLayout.CENTER );
    }

    public void actionPerformed( ActionEvent e) {
        Object o = e.getSource();
        if ( o == startButton ) {
            bouncing.start();
        }
        else if ( o == stopButton ) {
            bouncing.stop();
        }
    }

    public void setBallColor( Color c ) {
        bouncing.setBallColor( c );
    }

    public static void main( String[] args ) {
       /* create frame */
       JFrame frame = new JFrame();

       ButtonsAndBouncing bouncing = new ButtonsAndBouncing();
       frame.setSize( bouncing.getPreferredSize() );
       frame.setTitle( bouncing.getClass().getName() );
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.add( bouncing );
       frame.setVisible( true );
    }
}
