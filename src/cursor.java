import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
class cursor extends JFrame implements ActionListener {
    // frame

    //dialogbox
    static JDialog dialog;

    // label
    static Label l;
    //textfield to write texts, here to write mouse cursor filenames
    static JTextField tf;
    File selectedFile;
public static String s;
    // launchpage object
    JFileChooser fileChooser;
    FileNameExtensionFilter filter;
    int choice;
    int result;



    // default constructor, it will be called in the other class
    cursor() {
        //declaration of jdialog and set his properties
        dialog = new JDialog();
        dialog.setSize(400, 200);
        dialog.setLocation(600,200);
        dialog.setLayout(null);
        //defining the label and the textfield layput
        l = new Label("Dateiname einlesen. Write the name capitalised");
        tf = new JTextField();
        tf.setBounds(150, 60, 80, 30);
        l.setBounds(70, 20, 2000, 30);

       // JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("use.home")));


        // declaring the Buttons and defining their properties(layout , text to be shown
        JButton submit = new JButton("Übernehmen");
        submit.setVisible(true);
        submit.setBounds(0, 110, 120, 30);

        JButton schliessen = new JButton("Schließen");
        schliessen.setVisible(true);
        schliessen.setBounds(285, 110, 90, 30);

        //add  the compenents to the dialogbox
        dialog.add(submit);
        dialog.add(schliessen);
        dialog.add(l);
        dialog.add(tf);

        dialog.setVisible(true);
        //add action Listner to make the click react
        submit.addActionListener(this);
        schliessen.addActionListener(this);
         fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         filter = new FileNameExtensionFilter(
                "BMP Images", "bmp");
       // fileChooser.setFileFilter(filter);
         choice=JOptionPane.NO_OPTION;
        //do {
             result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                s = selectedFile.getName();
                tf.setText(s);
          //      choice = JOptionPane.showConfirmDialog(null, "\n\nWould you like to try another file?", "BMP File chooser", JOptionPane.YES_NO_OPTION);
                System.out.println("Selected file: " + selectedFile.getName());
            }
        //}while (choice==JOptionPane.YES_OPTION);



//Make dialog visible


        //int result=fileChooser.showOpenDialog(dialog);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Launchpage Hauptklasse.Hauptklasse.lp=new Launchpage();
        

        //decalring a button text string to get the written text from the textfield
       // tf.setText(selectedFile.getName());
        String buttonText = tf.getText();
        if(e.getActionCommand().equals("Übernehmen") && tf.getText().equals(s) ){
           /* Cursor c = getToolkit().createCustomCursor(
                    new ImageIcon(s).getImage(),
                    new Point(10,10), "Cursor" );*/
            dialog.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon(s).getImage(),
                    new Point(10,10),"custom cursor"));
            Hauptklasse.launchpage.getFrame().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    new ImageIcon(s).getImage(),
                    new Point(10,10),"custom cursor"));
            Hauptklasse.launchpage.getFrame().setTitle("SMILY_CUSTOM CURSOR");

          //  dialog.setCursor(c);
        }
        if(e.getActionCommand().equals("Übernehmen") && !tf.getText().substring(tf.getText().length()-4).equals(".bmp")){
            JOptionPane.showMessageDialog(null, "Ungültige Mousezeiger Dateiname ");
            tf.setText("");
            do {
                result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    s = selectedFile.getName();
                    tf.setText(s);
                    choice = JOptionPane.showConfirmDialog(null, "\n\nWould you like to try another file?", "BMP File chooser", JOptionPane.YES_NO_OPTION);
                    System.out.println("Selected file: " + selectedFile.getName());
                }
            }while (choice==JOptionPane.YES_OPTION);
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            Hauptklasse.launchpage.Setcurortitle(Cursor.DEFAULT_CURSOR,"DEFAULT CURSOR");
        }

        if(e.getActionCommand().equals("Übernehmen")){
            switch (buttonText){
               ////making changes for evry text input and at the same time pressing the button übernehmen
                // with dialogsetcursor it will change the cursor in the dialog , and Hauptklasse.lp as launchpage object will change it in the main

                case "CROSSHAIR.bmp":
                    dialog.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));;
                    Hauptklasse.launchpage.Setcurortitle(Cursor.CROSSHAIR_CURSOR,"CROSSHAIR CURSOR");
                    break;
                case "E_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.E_RESIZE_CURSOR,"E_RESIZE CURSOR");
                    break;
                case "HAND.bmp":
                    dialog.setCursor(new Cursor(Cursor.HAND_CURSOR));;
                    Hauptklasse.launchpage.Setcurortitle(Cursor.HAND_CURSOR,"HAND CURSOR");

                    break;
                case "MOVE.bmp":
                    dialog.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.MOVE_CURSOR,"MOVE CURSOR");
                    break;
                case "N_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.N_RESIZE_CURSOR,"N_RESIZE CURSOR");
                    break;
                case "NE_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.NE_RESIZE_CURSOR,"NE_RESIZE CURSOR");
                    break;
                case "NW_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.NW_RESIZE_CURSOR,"NW_RESIZE CURSOR");
                    break;
                case "SE_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.SE_RESIZE_CURSOR,"SE_RESIZE CURSOR");
                    break;
                case "SW_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.SW_RESIZE_CURSOR,"SW_RESIZE CURSOR");
                    break;
                case "W_RESIZE.bmp":
                    dialog.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.W_RESIZE_CURSOR,"W_RESIZE CURSOR");
                    break;
                case "TEXT.bmp":
                    dialog.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.TEXT_CURSOR,"TEXT CURSOR");
                    break;
                case "WAIT.bmp":
                    startWaitCursor(dialog.getRootPane());
                    Hauptklasse.launchpage.Setcurortitle(Cursor.WAIT_CURSOR,"WAIT CURSOR");
                    break;
                case "DEFAULT.bmp":
                    dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    Hauptklasse.launchpage.Setcurortitle(Cursor.DEFAULT_CURSOR,"DEFAULT CURSOR");
                    break;
                // in this example , we are creating a customised cursor , here a smily face closing hes left eye
                //if the the filename dont represent any mouse cusor, showing a alert box and telling the user to try again
                default:
                   // JOptionPane.showMessageDialog(null, "Ungültige Mousezeiger Dateiname , try again");
                    //tf.setText("");
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