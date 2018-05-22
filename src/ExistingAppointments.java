import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExistingAppointments extends JPanel{
    public static int EA;
    public ExistingAppointments(int i)
    {
        Database db_obj = new Database();

        ExistingAppointments.EA = i-1;

        JFrame frame = new JFrame("Patient Informations");
        Font tr = new Font("Times New Roman",Font.PLAIN+Font.BOLD,18);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(50,300,140,30);

        JButton deleteButton = new JButton("Delete Appointment");
        deleteButton.setBounds(230,300,135,30);

        JLabel lbl1 = new JLabel("Patient: " + db_obj.NameArray[EA]);
        lbl1.setFont(tr);
        lbl1.setBounds(80, 10, 180, 50);


        JLabel lbl2 = new JLabel("Phone/Email: " + db_obj.PhoneArray[EA]);
        lbl2.setFont(tr);
        lbl2.setBounds(80, 40, 300, 50);

        JLabel lbl3 = new JLabel("Date: " + db_obj.DateArray[EA]);
        lbl3.setFont(tr);
        lbl3.setBounds(80, 70, 300, 50);

        JLabel lbl4 = new JLabel("Time: " + db_obj.TimeArray[EA]);
        lbl4.setFont(tr);
        lbl4.setBounds(80, 100, 180, 50);

        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(lbl4);

        frame.add(closeButton);
        frame.add(deleteButton);

        frame.add(new JLabel(new ImageIcon("D:\\folderi.png")));

        frame.setBounds(400,200,450,450);
        frame.setVisible(true);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db_obj.delete(EA);
                frame.setVisible(false);

            }
        });

    }
}
