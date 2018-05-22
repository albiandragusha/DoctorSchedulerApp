import javax.swing.*;

public class Database {
    private static int Appointments;

    private static String Name;
    private static String Phone;
    private static String Date;
    private static String Time;

    public static String [] NameArray = new String[100];
    public static String [] PhoneArray = new String[100];
    public static String [] DateArray = new String[100];
    public static String [] TimeArray = new String[100];


    public void setName(String Name)
    {
        Database.Name=Name;
    }
    public String getName()
    {
        return Name;
    }
    public void setPhone(String Phone)
    {
        Database.Phone =Phone;
    }
    public String getPhone()
    {
        return Phone;
    }

    public void setDate(String Date)
    {
        Database.Date =Date;
    }
    public String getDate()
    {
        return Date;
    }

    public void setTime(String Time)
    {
        Database.Time =Time;
    }
    public String getTime()
    {
        return Time;
    }

    public void setAppointments(int i)
    {
        Database.Appointments=i;

    }
    public int getAppointments()
    {
        return Appointments+1;
    }
    public Database() {
        NameArray[Appointments]=getName();
        PhoneArray[Appointments]=getPhone();
        DateArray[Appointments]=getDate();
        TimeArray[Appointments]=getTime();

    }

    public boolean delete(int index)
    { boolean result = false;
        if (NameArray[index]  != null )
        {
            NameArray[index] = null;
            PhoneArray[index] = null;
            DateArray[index] = null;
            TimeArray[index] = null;
            JOptionPane.showMessageDialog(null,"Successfully Deleted Appointment");
            result = true;
        }


    return result;
    }

    }
