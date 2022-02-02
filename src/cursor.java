import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class cursor extends JFrame implements ActionListener {
    // frame
    static JFrame f;
    //dialogbox
    static JDialog dialog;

    // label
    static Label l;
    //textfield to write texts, here to write mouse cursor filenames
    static JTextField tf;
    static JLabel ls;

    // launchpage object
    Launchpage lp=new Launchpage();

    // default constructor, it will be called in the other class
    cursor() {
        //declaration of jdialog and set his properties
        dialog = new JDialog();
        dialog.setSize(400, 200);
        dialog.setLayout(null);
        //defining the label and the textfield layput
        l = new Label("Dateiname einlesen. Write the name capitalised");
        tf = new JTextField();
        tf.setBounds(150, 60, 100, 40);
        l.setBounds(70, 20, 2000, 40);

        // declaring the Buttons and defining their properties(layout , text to be shown
        JButton button = new JButton("Übernehmen");
        button.setVisible(true);
        button.setBounds(0, 110, 150, 40);

        JButton button1 = new JButton("Schließen");
        button1.setVisible(true);
        button1.setBounds(285, 110, 100, 40);

        //add  the compenents to the dialogbox
        dialog.add(button);
        dialog.add(button1);
        dialog.add(l);
        dialog.add(tf);


        //add action Listner to make the click react
        button.addActionListener(this);
        button1.addActionListener(this);
//Make dialog visible
        dialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //decalring a button text string to get the written text from the textfield
        String buttonText = new String(((JButton) e.getSource()).getText());

        //making changes for evry text input and at the same time pressing the button übernehmen
        //with dialogsetcursor it will change the cursor in the dialog , and lp as launchpage object will change it in the main , and it also will change the titel to the cursor name

        //for example hier changing the mouse cursor to CROSSHAIR an the title to CROSSHAIR CURSOR
        if (tf.getText().equals("CROSSHAIR") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            lp.getFrame().setTitle("CROSSHAIR CURSOR");
        }
        else if (tf.getText().equals("E_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            lp.getFrame().setTitle("E_RESIZE CURSOR");
        }
        else if (tf.getText().equals("HAND") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.HAND_CURSOR));
            lp.getFrame().setTitle("HAND CURSOR");
        }
        else if (tf.getText().equals("MOVE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.MOVE_CURSOR));
            lp.getFrame().setTitle("MOVE CURSOR");
        }
        else if (tf.getText().equals("N_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            lp.getFrame().setTitle("N_RESIZE CURSOR");
        }

        else if (tf.getText().equals("NE_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            lp.getFrame().setTitle("NE_RESIZE CURSOR");

        }
        else if (tf.getText().equals("NW_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            lp.getFrame().setTitle("NW_RESIZE CURSOR");
        }
        else if (tf.getText().equals("SE_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            lp.getFrame().setTitle("SE_RESIZE CURSOR");
        }
        else if (tf.getText().equals("SW_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            lp.getFrame().setTitle("SW_RESIZE CURSOR");
        }
        else if (tf.getText().equals("W_RESIZE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
            lp.getFrame().setTitle("W_RESIZE CURSOR");
        }
        else if (tf.getText().equals("TEXT") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.TEXT_CURSOR));
            lp.getFrame().setTitle("TEXT CURSOR");
        }
        else if (tf.getText().equals("WAIT") && e.getActionCommand().equals("Übernehmen")) {
            // dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            startWaitCursor(dialog.getRootPane());
            lp.getFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
            lp.getFrame().setTitle("WAIT CURSOR");
        }
        else if (tf.getText().equals("CUSTOM") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.CUSTOM_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.CUSTOM_CURSOR));
        }
        else  if (tf.getText().equals("DEFAULT") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            lp.getFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            lp.getFrame().setTitle("DEFAULT CURSOR");
        }// in this example , we are creating a customised cursor , here a smily face closing hes left eye
        else  if (tf.getText().equals("SMILE") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon("smile.png").getImage(),
                    new Point(0,0),"custom cursor"));
            lp.getFrame().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon("smile.png").getImage(),
                    new Point(0,0),"custom cursor"));
            lp.getFrame().setTitle("SMILY_CUSTOM CURSOR");
        }//in this example chaning also the cursor for a customised, but here i am bullying my friend
        else  if (tf.getText().equals("WASSIM") && e.getActionCommand().equals("Übernehmen")) {
            dialog.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon("wassim.jpeg").getImage(),
                    new Point(0,0),"custom cursor"));
            lp.getFrame().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon("smile.png").getImage(),
                    new Point(0,0),"custom cursor"));
        }
// if the button schließen(close) is clicked , leting the user to confirm if he is sure , and if he want to close it , only the dialog will be closed
        else if (e.getActionCommand().equals("Schließen")) {

            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);

            if(dialogButton == JOptionPane.YES_OPTION) {
                //System.exit(0);
                dialog.setVisible(false);
            }
            else
            {remove(dialogButton);}
        }
        //if the the filename dont represent any mouse cusor, showing a alert box and telling the user to try again
        else {
            JOptionPane.showMessageDialog(null, "Ungültige Mousezeiger Dateiname , try again");
        }

    }




    //methode to change the mouse cursor , but i need to pass evry type i a new methode , just use it for wait cursor type
    public static void startWaitCursor(JComponent component) {
        RootPaneContainer root =
                (RootPaneContainer) component.getTopLevelAncestor();
        root.getGlassPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        root.getGlassPane().setVisible(true);
    }
}