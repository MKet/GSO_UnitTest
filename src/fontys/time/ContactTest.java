package fontys.time;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact;
    private Appointment app;
    private Appointment app2;
    @Before
    public void setUp() throws Exception {
        contact = new Contact("Jonny");
        app = new Appointment("TimeToday", new TimeSpan(new Time(2017,9,27,12,36), new Time(2017,9,27,13,30)));
        app2 = new Appointment("TimeToday2", new TimeSpan(new Time(2018,9,27,12,36), new Time(2019,9,27,13,30)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void createContact() throws Exception {
     Contact test = new Contact("");
     Assert.fail("No name");
    }


    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Jonny", contact.getName());
    }

    @Test
    public void addAppointment() throws Exception {
         assertTrue(contact.addAppointment(app));
    }

    @Test(expected = Exception.class)
    public void addAppointment_Same() throws Exception {
        contact.addAppointment(app);
        assertTrue(contact.addAppointment(app));
    }



    @Test(expected = IllegalArgumentException.class)
    public void addAppointment_Null() throws Exception {
        contact.addAppointment(null);
        Assert.fail("Null not allowed");
    }

    @Test
    public void removeAppointment() throws Exception {
            boolean result = false;
            contact.addAppointment(app);
            contact.addAppointment(app2);
            contact.removeAppointment(app);
            Iterator<Appointment> iterator =  contact.appointments();
            Appointment point;
            while (iterator.hasNext()) {
                point = iterator.next();

                if (app == point) {
                    result = true;
                    break;
                }
            }

        assertFalse(result);
    }

    @Test (expected = Exception.class)
    public void removeAppointment_NoApp() throws Exception {
        boolean result = false;
        contact.removeAppointment(app);
        Iterator<Appointment> iterator =  contact.appointments();
        Appointment point;
        while (iterator.hasNext()) {
            point = iterator.next();

            if (app == point) {
                result = true;
                break;
            }
        }

        assertFalse(result);
    }

    @Test
    public void appointments() throws Exception {
    }

}