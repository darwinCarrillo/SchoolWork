import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ButtonsAndBouncingAndColor extends JPanel
    implements ActionListener
{
    private static String[] colors = {
       "red", "green", "blue", "magenta", "yellow", "cyan", "grey"
    };
    private static Color[] awtColors = {
       Color.red, Color.green, Color.blue,
       Color.magenta, Color.yellow, Color.cyan, Color.gray
    };

    private static Color lookup( String col ) {
        for( int i = 0 ; i < colors.length; i++ ) {
            if ( colors[i].equals( col ) ) {
                return awtColors[i];
            }
        }
        return Color.black;  // unknown color default
    }

    private ButtonsAndBouncing bouncing;
    private JButton[] colorButtons;

    public ButtonsAndBouncingAndColor() {
        setLayout( new BorderLayout() );

        JPanel p = new JPanel( new GridLayout(2, 3) );
        colorButtons = new JButton[ colors.length ];
        for( int i = 0 ; i < colors.length; i++ ) {
           colorButtons[i] = new JButton( colors[i] );
           colorButtons[i].addActionListener( this );
           colorButtons[i].setForeground( awtColors[i] );
           p.add( colorButtons[i] );
        }
        add( p, BorderLayout.NORTH );

        bouncing = new ButtonsAndBouncing();
        add( bouncing, BorderLayout.CENTER );
    }

    public void actionPerformed( ActionEvent e ) {
        Object o = e.getSource();
        JButton b = (JButton)o;
        bouncing.setBallColor( lookup( b.getText() ));
    }

    public static void main( String[] args ) {
       /* create frame */
       JFrame frame = new JFrame();

       ButtonsAndBouncingAndColor bouncing =
           new ButtonsAndBouncingAndColor();
       frame.setSize( bouncing.getPreferredSize() );
       frame.setTitle( bouncing.getClass().getName() );
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.add( bouncing );
       frame.setVisible( true );
    }
}
