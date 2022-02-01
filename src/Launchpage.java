import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Launchpage extends JFrame implements ActionListener {
    static JFrame frame;
    private static JDialog dialog;
    private static JPanel mainGui;
    private static JPanel buttonPanel;
    private static  JMenuItem menusimpleitemA, menusimpleitemB;
    private static   JMenuBar mbar;
    private static   JMenu menu1;

    Launchpage(){
        //eigenschaften von frame
        frame = new JFrame("GUI-Hausarbeit");
        JPanel panel = new JPanel();
        frame.setSize(300, 200);
        //for exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog = new JDialog(frame, "Dialog", true);

        mbar = new JMenuBar();
        frame.setJMenuBar(mbar);
        menu1 = new JMenu("Datei");
        mbar.add(menu1);
        menusimpleitemA = new JMenuItem("Mauszeiger einlesen");
        menu1.add(menusimpleitemA);
        menu1.add(new JSeparator());
        menusimpleitemB = new JMenuItem("Schließen");
        menu1.add(menusimpleitemB);

        menusimpleitemA.addActionListener(this);
        menusimpleitemB.addActionListener(this);

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
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Schließen")) {
            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);

            if(dialogButton == JOptionPane.YES_OPTION) {
                System.exit(0);}else {remove(dialogButton);}

        }  if (e.getSource()==menusimpleitemA) {
            cursor c=new cursor();
            int y=c.getcursortype();
            frame.setCursor(new Cursor(y));

        }
    }
}
