package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Contact {

    private String name;

    private List<Appointment> appointments;
    /**
     * Constructs a contact object
     * @param name
     */
    public Contact(String name){
        this.name = name;
        this.appointments = new ArrayList<Appointment>();
        if(name.isEmpty() || name == null){
            try{
                throw new Exception("name is empty");
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }

    /**
     * Get a contact name
     * @return name
     *
     */
    public String getName(){
        return name;
    }

    /**
     * Create an appointment
     * @param a
     * @return a true if appointment is successfully created
     * @return a false if appointment was failed to create
     */
    boolean addAppointment(Appointment a) throws Exception{

    }

    /**
     * Remove an appointment
     * @param a
     */
    void removeAppointment(Appointment a){
        boolean result = false;
    }

    /**
     * gets a iterator of appointments
     * @return iteration of appointments
     */
    public Iterator<Appointment> appointments(){
        return appointments.iterator();
    }
}
