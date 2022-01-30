import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gui_main {
   /* // global deklaration
    private static JFrame frame;
    private static JDialog dialog;
    private static JPanel mainGui;
    private static JPanel buttonPanel;
    static  JMenuItem menusimpleitemA, menusimpleitemB;
*/

    public static void main(String args[]) {
        Launchpage l=new Launchpage();

    }
}





















      /*  //eigenschaften von frame
        frame = new JFrame("GUI-Hausarbeit");
        JPanel panel = new JPanel();
        frame.setSize(300, 200);
        //for exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog = new JDialog(frame, "Dialog", true);
/*
         mainGui = new JPanel(new BorderLayout());
        mainGui.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainGui.add(new JLabel("Contents go here"), BorderLayout.CENTER);
         buttonPanel = new JPanel(new FlowLayout());
        mainGui.add(buttonPanel, BorderLayout.SOUTH);

        JButton close = new JButton("Close");
        close.addActionListener(e->dialog.setVisible(false));

        buttonPanel.add(close);
        dialog.setContentPane(mainGui);
        dialog.pack();
        dialog.setVisible(true);*/

        /*JMenuBar mbar;
        JMenu menu1;

        mbar = new JMenuBar();
        frame.setJMenuBar(mbar);
        menu1 = new JMenu("Datei");
        mbar.add(menu1);
        menusimpleitemA = new JMenuItem("Mauszeiger einlesen");
        menu1.add(menusimpleitemA);
        menu1.add(new JSeparator());
        menusimpleitemB = new JMenuItem("Schließen");
        menu1.add(menusimpleitemB);


        menusimpleitemB.addActionListener(new MenuActionListener());
        //menusimpleitemA.addActionListener((a);


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

    static class MenuActionListener extends JFrame implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Schließen")) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(null, "Would You Like to Save your Previous Note First?", "Warning", dialogButton);

                if (dialogButton == JOptionPane.YES_OPTION) {
                    System.exit(1);
                }
            }  if (e.getSource()==menusimpleitemA) {
                cursor c=new cursor();
               // c.setVisible(true);
            }
        }*/

