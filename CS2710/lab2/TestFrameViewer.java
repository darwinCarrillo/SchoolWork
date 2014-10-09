import javax.swing.JFrame;

public class TestFrameViewer{
	public static void main(String [] args){
		JFrame frame = new JFrame();
		
		final int Frame_Width = 250;
		final int Frame_Height = 250;
		
		frame.setSize(Frame_Width, Frame_Height);
		frame.setTitle("A Test Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
}
}
