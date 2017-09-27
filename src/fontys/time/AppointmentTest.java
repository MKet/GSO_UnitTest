package fontys.time;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Marco Ketelaars
 */
public class AppointmentTest {

    Appointment appointment;
    TimeSpan span;

    @Before
    public void setup() {
        span = new TimeSpan(new Time(1995, 3, 31, 15, 35), new Time(2117, 3, 5, 13, 30));
        appointment = new Appointment("git gud", span);
    }

    @Test
    public void addContact() {
        assertTrue(appointment.addContact( new Contact("Rick")));
        assertTrue(appointment.invitees().hasNext());
    }

    @Test
    public void addConflictContact() {
        Contact contact = new Contact("Rick");

        TimeSpan span = new TimeSpan(new Time(1995, 3, 31, 15, 35), new Time(2000, 3, 5, 13, 30));
        contact.addAppointment(new Appointment(null, span));

        span = new TimeSpan(new Time(1998, 3, 31, 15, 35), new Time(2004, 7, 5, 13, 30));
        contact.addAppointment(new Appointment(null, span));

        assertFalse(appointment.addContact(contact));
    }


    @Test
    public void addContactTwice() {
        Contact contact = new Contact("Rick");

        assertTrue(appointment.addContact(contact));
        assertTrue(appointment.invitees().hasNext());
        assertFalse(appointment.addContact(contact));
    }

    @Test
    public void removeContact() {
        Contact contact = new Contact("Rick");
        appointment.addContact(contact);
        appointment.removeContact(contact);

        assertFalse(appointment.invitees().hasNext());
    }

    @Test
    public void getSubject() {
        assertEquals("git gud", appointment.getSubject());
    }

    @Test
    public void getSpan() {
        assertEquals(span, appointment.getTimeSpan());
    }
}
