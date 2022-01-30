import java.awt.*;
import javax.swing.*;
class cursor extends JFrame {
    // frame
    static JFrame f;

    // label
    static Label l, l1, l2;
    static JTextField tf;
    static JLabel ls;
    static JButton bestaetig,exit;

    // default constructor
    cursor()
    {
        try {
            // create a frame
            f = new JFrame("cursor");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(450,420);
            f.setLayout(null);

            // create e panel
            JPanel p = new JPanel();

            // create labels
            l = new Label("label one");
            l1 = new Label("label two");
            l2 = new Label("label three");
            tf=new JTextField();



            // create cursors
            Cursor c = new Cursor(CROSSHAIR_CURSOR);
            Cursor c1 = new Cursor(HAND_CURSOR);

            // get System cursor
            Cursor c2 = Cursor.getSystemCustomCursor("Invalid.32x32");

            // set cursor
            l.setCursor(c);
            l1.setCursor(c1);
            l2.setCursor(c2);

            // add labels to panel
            p.add(l);
            p.add(l1);
            p.add(l2);

            // add panel to the frame
            //f.add(p);
            //l=new Label("Dateiname einlesen");
            //tf=new JTextField();
            /*tf.setBounds(70,60,100,40);
            l.setBounds(70,20,130,40);`*/

            f.add(l);
            f.add(l1);
            //f.add(tf);

            // show the frame
            f.setVisible(true);
            f.setSize(250, 300);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // main class

}