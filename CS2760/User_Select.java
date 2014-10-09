import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Darwin Carrillo
 * Assignment #1
 */
public class User_Select extends javax.swing.JFrame {

    List<String> collected_Users = new ArrayList<String>();
    List<String> user_info = new ArrayList<String>();

    public User_Select() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file_Chooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUser_Info = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUser = new javax.swing.JList();
        bttnLoad = new javax.swing.JButton();

        file_Chooser.setFileFilter(new FileNameExtensionFilter("Text Files","txt"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstUser_Info.setColumns(20);
        lstUser_Info.setRows(5);
        jScrollPane1.setViewportView(lstUser_Info);

        lstUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstUser);

        bttnLoad.setText("Load File");
        bttnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Load file into the program and populate text field and list box
    private void bttnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnLoadActionPerformed
        //Start processing file if a file has been selected
        if (file_Chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            BufferedReader reader;
            String user_temp = "";
            //Attempt to open file for processing
            try {
                reader = new BufferedReader(new FileReader(file_Chooser.getSelectedFile()));
                //Read file until an empty line is found
                while (!(user_temp = reader.readLine()).equals("")){
                    //add line to user's information
                    user_info.add(user_temp);
                    //parse line to extract user name
                    user_temp = user_temp.substring(0, user_temp.indexOf(" "));
                    //add user name to user collection if not already recorded
                    if(collected_Users.indexOf(user_temp) < 0){
                      collected_Users.add(user_temp);
                   }
                }
                reader.close();
                Collections.sort(collected_Users);
                lstUser.setListData(collected_Users.toArray());
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(this, "Error: Can't load file. Please make sure you file adheres to the 'last' command output format.");
            }
        }
    }//GEN-LAST:event_bttnLoadActionPerformed

    private void lstUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUserMouseClicked
        String selected_user = (String) lstUser.getSelectedValue();
        StringBuilder info = new StringBuilder();
        //serach through user_info for all occurences of username and
        //build string
        for(String i : user_info){
            if(i.substring(0, i.indexOf(" ")).equals(selected_user)){
                info.append(i + "\n");
            }
        }
        lstUser_Info.setText(info.toString());
    }//GEN-LAST:event_lstUserMouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Select().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnLoad;
    private javax.swing.JFileChooser file_Chooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstUser;
    private javax.swing.JTextArea lstUser_Info;
    // End of variables declaration//GEN-END:variables
}
