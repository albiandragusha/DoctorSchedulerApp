import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startup {
    private int count = -1;
    public Startup()
    {
        Database db_obj = new Database();

        JFrame frame = new JFrame("MENU");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Font tr = new Font("Times New Roman",Font.PLAIN,20);

        JLabel tf = new JLabel("Hello Doctor!");
        tf.setFont(tr);
        tf.setBounds(230,210,150,30);

        JLabel jl = new JLabel("What Do You Want To Do? ");
        jl.setFont(tr);
        jl.setBounds(180,240,250,30);

        JButton newAButton = new JButton("New Appointment");
        newAButton.setBounds(90,430,140,30);

        JButton allAbutton = new JButton("All Appointments");
        allAbutton.setBounds(340,430,135,30);

        JButton closeButton = new JButton("Close Application");
        closeButton.setBounds(215,470,135,30);

        frame.add(tf);
        frame.add(jl);
        frame.add(newAButton);
        frame.add(allAbutton);
        frame.add(closeButton);
        frame.add(new JLabel(new ImageIcon("D:\\doctor.jpg")));
        frame.setBounds(350,120,600,600);
        frame.setVisible(true);

        newAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new CreatingAppointment();
                    count++;
                db_obj.setAppointments(count);
                }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        allAbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("From " + db_obj.getAppointments() + " Appointments,Type The Number Of Your Appointment");
                int i = Integer.valueOf(input);
                if (i<0 || i>db_obj.getAppointments())
                {
                    JOptionPane.showMessageDialog(null,"There's no appointment with this number");
                }
                else
                    {new ExistingAppointments(i);}

            }
        });


    }


}
