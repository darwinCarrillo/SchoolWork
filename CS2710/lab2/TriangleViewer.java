import javax.swing.JFrame;

public class TriangleViewer{

	public static void main(String[] args){
		JFrame frame = new JFrame();
		
		final int Frame_Width = 300;
		final int Frame_Height = 150;
		
		frame.setSize(Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Triangle component = new Triangle();
		frame.add(component);

		frame.setVisible(true);
}
}
