import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.swing.*;
class cursor extends JFrame implements ActionListener {
    // frame
    static JFrame frame;
    //dialogbox
    static JDialog dialog;

    // label
    static Label l;
    //textfield to write texts, here to write mouse cursor filenames
    static JTextField tf;
    static JLabel ls;

    // launchpage object



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
        JButton submit = new JButton("Übernehmen");
        submit.setVisible(true);
        submit.setBounds(0, 110, 150, 40);

        JButton schliessen = new JButton("Schließen");
        schliessen.setVisible(true);
        schliessen.setBounds(285, 110, 100, 40);

        //add  the compenents to the dialogbox
        dialog.add(submit);
        dialog.add(schliessen);
        dialog.add(l);
        dialog.add(tf);


        //add action Listner to make the click react
        submit.addActionListener(this);
        schliessen.addActionListener(this);
//Make dialog visible
        //gui_main.lp.setVisible(false);
        dialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Launchpage gui_main.gui_main.lp=new Launchpage();
        

        //decalring a button text string to get the written text from the textfield
        String buttonText = new String(tf.getText());
        if(e.getActionCommand().equals("Übernehmen")){
            switch (buttonText){
               ////making changes for evry text input and at the same time pressing the button übernehmen
                //        //with dialogsetcursor it will change the cursor in the dialog , and gui_main.lp as launchpage object will change it in the main , and it a
                case "CROSSHAIR":
                    dialog.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("CROSSHAIR CURSOR");
                    break;
                case "E_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("E_RESIZE CURSOR");
                    break;
                case "HAND":
                    dialog.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.HAND_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("HAND CURSOR");
                    break;
                case "MOVE":
                    dialog.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.MOVE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("MOVE CURSOR");
                    break;
                case "N_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("N_RESIZE CURSOR");
                    break;
                case "NE_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("NE_RESIZE CURSOR");
                    break;
                case "NW_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("NW_RESIZE CURSOR");
                    break;
                case "SE_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("SE_RESIZE CURSOR");
                    break;
                case "SW_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("SW_RESIZE CURSOR");
                    break;
                case "W_RESIZE":
                    dialog.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("W_RESIZE CURSOR");
                    break;
                case "TEXT":
                    dialog.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("TEXT CURSOR");
                    break;
                case "WAIT":
                    startWaitCursor(dialog.getRootPane());
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("WAIT CURSOR");
                    break;
                case "DEFAULT":
                    dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    gui_main.launchpage.getFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    gui_main.launchpage.getFrame().setTitle("DEFAULT CURSOR");
                    break;
                // in this example , we are creating a customised cursor , here a smily face closing hes left eye
                case "SMILE":
                    dialog.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                            new ImageIcon("smile.png").getImage(),
                            new Point(0,0),"custom cursor"));
                    gui_main.launchpage.getFrame().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                            new ImageIcon("smile.png").getImage(),
                            new Point(0,0),"custom cursor"));
                    gui_main.launchpage.getFrame().setTitle("SMILY_CUSTOM CURSOR");
                    break;
                case "CUSTOM":
                    dialog.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                            new ImageIcon("wassim.jpeg").getImage(),
                            new Point(0,0),"custom cursor"));
                    gui_main.launchpage.getFrame().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                            new ImageIcon("smile.png").getImage(),
                            new Point(0,0),"custom cursor"));
                    break;
                //if the the filename dont represent any mouse cusor, showing a alert box and telling the user to try again
                default:
                    JOptionPane.showMessageDialog(null, "Ungültige Mousezeiger Dateiname , try again");
            }
        }

// if the button schließen(close) is clicked , leting the user to confirm if he is sure , and if he want to close it , only the dialog will be closed
        //else
            if (e.getActionCommand().equals("Schließen")) {

            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);

            if(dialogButton == JOptionPane.YES_OPTION) {
                //System.exit(0);
                dialog.setVisible(false);
            }
            else
            {remove(dialogButton);}
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