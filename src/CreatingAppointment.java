import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreatingAppointment extends JPanel {

    private String Name;
    private String Phone;
    private String Date;
    private String Time;

    public CreatingAppointment()
    {
        Database db_obj = new Database();

        JFrame frame = new JFrame("Creating Appointment");
        frame.setSize(600,600);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(400,200,500,500);

        JPanel panel = new JPanel();


        JButton personal_informationButton = new JButton("Personal Information");

        JButton choose_timeButton = new JButton("Choose Time");

        JButton doneButton = new JButton("Done");
        Container contentPane = frame.getContentPane();
        contentPane.add(doneButton,BorderLayout.CENTER);

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());

        DateFormat sysDate = new SimpleDateFormat("EEE MMM d yyyy ");

        Calendar calendar = picker.getMonthView().getCalendar();
        calendar.setTime(new Date());
        picker.getMonthView().setLowerBound(calendar.getTime());

        frame.setLayout(new BorderLayout());
        frame.setContentPane(new JLabel(new ImageIcon("D:\\kalendari.jpg")));
        frame.setLayout(new FlowLayout());

        panel.add(personal_informationButton);
        panel.add(picker);
        panel.add(choose_timeButton);
        panel.add(doneButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        personal_informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Name = JOptionPane.showInputDialog("Name And Last Name Of Patient?");
                db_obj.setName(Name.toUpperCase());

                    Phone = JOptionPane.showInputDialog("Phone Number/Email Addres Of Patient");
                    db_obj.setPhone(Phone);

                String r = "000000000";
                 if (Phone.length()<r.length())
                {JOptionPane.showMessageDialog(null,"Please Type a Valid P.N/E.A");
                    Phone = JOptionPane.showInputDialog("Phone Number/Email Addres Of Patient");
                    db_obj.setPhone(Phone);}

                    }

        });

        choose_timeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Date = sysDate.format(picker.getDate());

                if (Date.charAt(0)=='S')
                {JOptionPane.showMessageDialog(null,"Weekends are not alllowed for Appointment");}
                else
                { db_obj.setDate(Date); }

                Component source = (Component) actionEvent.getSource();
                Object response = JOptionPane.showInputDialog(source,
                        null,
                        null, JOptionPane.QUESTION_MESSAGE,
                        null,new String[]{"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"},"10:00");
                Time=response.toString();
                db_obj.setTime(Time);
            }
        });



        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean CheckPoint = false;
                    for (int i=0;i<db_obj.getAppointments();i++)
                    {
                        if(Date.equals(db_obj.DateArray[i]) && Time.equals(db_obj.TimeArray[i]))
                        {CheckPoint=true;}
                    }
                    if (CheckPoint)
                {JOptionPane.showMessageDialog(null,"Appointment is Already Taken");}
                else{
                JOptionPane.showMessageDialog(null,"Appointment Added Successfully");
                frame.setVisible(false);}
            }
        });


    }


}
