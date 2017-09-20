package fontys.time.test;

import fontys.time.DayInWeek;
import fontys.time.Time;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TimeTest {

    private Time time = new Time(1996, 12,11,4,30);


    @Test
    public void testGetDayInWeek() throws Exception {
        assertEquals(DayInWeek.WED, time.getDayInWeek());
    }

    @Test
    public void getYear() throws Exception {
        assertEquals(1996, time.getYear());
    }

    @Test
    public void getMonth() throws Exception {
        assertEquals(12 , time.getMonth());
    }

    @Test
    public void getDay() throws Exception {
        assertEquals(11, time.getDay());
    }

    @Test
    public void getHours() throws Exception {
        assertEquals(4, time.getHours());
    }

    @Test
    public void getMinutes() throws Exception {
        assertEquals(30, time.getMinutes());
    }

    @Test
    public void plus() throws Exception {
        Time newTime = (Time) time.plus(10);
        assertEquals(40, newTime.getMinutes());
    }

    @Test
    public void compareTo() throws Exception {
        Time time2 = new Time(1996,12,13,12,30);
        Time sameTime = new Time(1996,12,11,4,30);
        assertEquals(0, time.compareTo(sameTime));
        assertEquals(1, time.compareTo(time2));
    }

    @Test
    public void difference() throws Exception {
        Time newTime = (Time) time.plus(10);
        assertEquals(10, newTime.difference(time));
    }

}