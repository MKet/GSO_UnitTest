package fontys.time;

import org.junit.Before;
import org.junit.Test;

public class AppointmentTest {

    Appointment appointment;
    @Before
    public void setup() {
        TimeSpan span = new TimeSpan(new Time(1995, 3, 31, 15, 35), new Time(2017, 3, 5, 13, 30));
        appointment = new Appointment("git gud", span);
    }

    @Test
    public void addContact() { }
}
