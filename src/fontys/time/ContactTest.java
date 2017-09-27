package fontys.time;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact;
    private List<Appointment> apps;
    @Before
    public void setUp() throws Exception {
        contact = new Contact("Jonny");
        apps = new List<Appointment>();

    }


    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Jonny", contact.getName());
    }

    @Test
    public void addAppointment() throws Exception {
        Appointment app = new Appointment("TimeToday", new TimeSpan(new Time(2017,9,27,12,36), new Time(2017,9,27,13,30)));

    }

    @Test
    public void removeAppointment() throws Exception {
    }

    @Test
    public void appointments() throws Exception {
    }

}