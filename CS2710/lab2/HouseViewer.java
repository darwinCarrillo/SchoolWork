import javax.swing.JFrame;

public class HouseViewer{

	public static void main(String [] args){

		JFrame frame = new JFrame();
		
		final int Frame_Width = 500;
		final int Frame_Lenght = 500;

		frame.setSize(Frame_Width, Frame_Lenght);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HouseComponent house = new HouseComponent();
		frame.add(house);

		frame.setVisible(true);
}
}
