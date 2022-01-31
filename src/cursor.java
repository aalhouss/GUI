import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class cursor extends JFrame implements ActionListener {
    // frame
    static JFrame f;
    static JDialog dialog;

    // label
    static Label l, l1, l2;
    static JTextField tf;
    static JLabel ls;
    static JButton bestaetig,exit;
    private int a;
    static Cursor cursor;

    // default constructor
    cursor()
    {
        dialog=new JDialog();
        dialog.setSize(300, 200);
        dialog.setLayout(null);
        l=new Label("Dateiname einlesen");
        tf=new JTextField();
        tf.setBounds(70,60,100,40);
        l.setBounds(70,20,130,40);



        JButton button = new JButton("Übernehmen");
        button.setVisible(true);
        button.setBounds(0,110,100,40);

        JButton button1 = new JButton("Schließen");
        button1.setVisible(true);
        button1.setBounds(185,110,100,40);

        //add comp
        dialog.add(button);
        dialog.add(button1);
        dialog.add(l);
        dialog.add(tf);
         cursor = new Cursor(Cursor.HAND_CURSOR);



        //add action Listner
        button.addActionListener(this);
        button1.addActionListener(this);
//Make dialog visible
        dialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = new String ( ( ( JButton ) e.getSource ( ) ).getText ( ) );

        if(tf.getText().equals("CROSSHAIR") && e.getActionCommand().equals("Übernehmen")){
        dialog.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
        if(tf.getText().equals("E_RESIZE_CURSOR") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        }
        if(tf.getText().equals("HAND_CURSOR") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(tf.getText().equals("MOVE_CURSOR") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }
        if(tf.getText().equals("N_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        }

        if(tf.getText().equals("NE_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        }
        if(tf.getText().equals("NW_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        }
        if(tf.getText().equals("SE_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        }
        if(tf.getText().equals("SW_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
        }
        if(tf.getText().equals("W_RESIZE") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
        }
        if(tf.getText().equals("TEXT") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        }
        if(tf.getText().equals("WAIT") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        if(tf.getText().equals("CUSTOM") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.CUSTOM_CURSOR));
        }
        if(tf.getText().equals("DEFAULT") && e.getActionCommand().equals("Übernehmen")){
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        if(e.getActionCommand().equals("Schließen")){

            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null, "Would You Like to Save your Previous Work First?", "Warning", dialogButton);

            if (dialogButton == JOptionPane.YES_OPTION) {
                System.exit(1);
            }

        }
    }

    // main class

}