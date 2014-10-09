class EnterExitListener implements MouseListener
{
   public void mouseEntered(MouseEvent event)
   {
      frame.getContentPane().setBackground(Color.RED);
   }

   public void mouseExited(MouseEvent event)
   {
      frame.getContentPane().setBackground(Color.BLUE);
   }

   // Do-nothing methods
   public void mousePressed(MouseEvent event) {}
   public void mouseReleased(MouseEvent event) {}
   public void mouseClicked(MouseEvent event) {}
}
