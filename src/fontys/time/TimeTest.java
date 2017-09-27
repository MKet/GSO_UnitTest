package fontys.time;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author Sven
 */

public class TimeTest {

    private Time time = new Time(1996, 12,11,4,30);


    @Test
    public void testGetDayInWeek() throws Exception {
        assertEquals(DayInWeek.WED, time.getDayInWeek());
        Time time2 = new Time(1996, 12,8,4,30);
        Time time3 = new Time(1996, 12,9,4,30);
        Time time4 = new Time(1996, 12,10,4,30);
        Time time5 = new Time(1996, 12,12,4,30);
        Time time6 = new Time(1996, 12,13,4,30);
        Time time7 = new Time(1996, 12,14,4,30);

        assertEquals(DayInWeek.SUN, time2.getDayInWeek());
        assertEquals(DayInWeek.MON, time3.getDayInWeek());
        assertEquals(DayInWeek.TUE, time4.getDayInWeek());
        assertEquals(DayInWeek.THU, time5.getDayInWeek());
        assertEquals(DayInWeek.FRI, time6.getDayInWeek());
        assertEquals(DayInWeek.SAT, time7.getDayInWeek());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDayInWeekExceptionMonth() throws Exception{
        Time errorTime = new Time(1996, 13,32,24,65);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetDayInWeekExceptionDay() throws Exception{
        Time errorTime = new Time(1996, 12,32,24,65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDayInWeekExceptionHour() throws Exception{
        Time errorTime = new Time(1996, 12,30,25,65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDayInWeekExceptionMinute() throws Exception{
        Time errorTime = new Time(1996, 12,30,20,70);
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