import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Launchpage extends JFrame implements ActionListener {
    private static JFrame frame;
    private static JDialog dialog;
    private static  JMenuItem menusimpleitemA, menusimpleitemB;
    private static   JMenuBar mbar;
    private static   JMenu menu1;
    private  static  cursor c=null;

    Launchpage(){
        //eigenschaften von frame
        frame = new JFrame("GUI-Hausarbeit");
        JPanel panel = new JPanel();
        frame.setSize(350, 250);
        //for exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog = new JDialog(frame, "Dialog", true);
        // menubar zur Auswählen
        mbar = new JMenuBar();
        frame.setJMenuBar(mbar);
        //erste menu (und die einzige)
        menu1 = new JMenu("Datei");
        mbar.add(menu1);
        //menuitems
        menusimpleitemA = new JMenuItem("Mauszeiger einlesen");
        menu1.add(menusimpleitemA);
        menu1.add(new JSeparator());
        menusimpleitemB = new JMenuItem("Schließen");
        menu1.add(menusimpleitemB);

        // Actionlistner to react when item is clicked
        menusimpleitemA.addActionListener(this);
        menusimpleitemB.addActionListener(this);

        //to close the frame after showing a confirmation dialog , and let the frame to be closed with ALT+F4
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(frame,
                        "Do you want to Exit ?", "Exit Confirmation : ",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        //Just to make the frame more beautiful i added th köln logo as background
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("thkoeln.png")))));
        } catch (IOException e) {
            e.printStackTrace();

        }
        // make the frame visible
        frame.setVisible(true);

    }
    // actionlistner methode , where after click start doing prefered things
    public void actionPerformed(ActionEvent e) {
        //like here closing after menuitem schließen clicked , with  a confirmation message
        if (e.getActionCommand().equals("Schließen")) {
            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);

            if(dialogButton == JOptionPane.YES_OPTION) {
                System.exit(0);}else {remove(dialogButton);}
            //if the first menu item is clicked , call a cursor object, where the dialog will be open
        }  if (e.getSource()==menusimpleitemA) {
            c=new cursor();
        }

    }
    // help methode to use frame globally
    public JFrame getFrame(){
        return frame;
    }
}