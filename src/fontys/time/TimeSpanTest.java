package fontys.time;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeSpanTest {

    private TimeSpan ts;
    private ITime t1;
    private ITime t2;

    @Before
    public void setUp() throws Exception {
        t1 = new Time(1995, 3, 31, 15, 45);
        t2 = new Time(2017, 4, 1, 15, 45);
        ts = new TimeSpan(t1, t2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentConstructor() {
        new TimeSpan(t2, t1);
    }

    @Test
    public void getBeginTime() throws Exception {
        assertEquals(ts.getBeginTime(), t1);
    }

    @Test
    public void getEndTime() throws Exception {
        assertEquals(ts.getEndTime(), t2);
    }

    @Test
    public void length() throws Exception {
        assertEquals(11573280, ts.length());
    }

    @Test
    public void lengthMinutesOnly() throws Exception {
        ts = new TimeSpan(
                new Time(2000, 3, 5, 14, 5),
                new Time(2000, 3, 5, 14, 10));
        assertEquals(5, ts.length());
    }

    @Test
    public void setBeginTime() throws Exception {
        ITime newTime = new Time(2000, 3, 31, 15, 45);

        ts.setBeginTime(newTime);

        assertTrue(ts.getBeginTime() != t1 && ts.getBeginTime() == newTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBeginTimeHigherThanEndTime() throws Exception {
        ITime newTime = new Time(2020, 3, 31, 15, 45);

        ts.setBeginTime(newTime);
    }

    @Test
    public void setEndTime() throws Exception {
        ITime newTime = new Time(2018, 3, 31, 15, 45);

        ts.setEndTime(newTime);

        assertEquals(ts.getEndTime(), newTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEndTimeLowerthanBeginTime() throws Exception {
        ITime newTime = new Time(1980, 3, 31, 15, 45);

        ts.setEndTime(newTime);
    }

    @Test
    public void move_positive() throws Exception {
        int moveMin = 5;
        int beginMinutes = ts.getBeginTime().getMinutes();
        int endMinutes = ts.getEndTime().getMinutes();
        ts.move(moveMin);

        assertEquals(beginMinutes  + moveMin, ts.getBeginTime().getMinutes());
        assertEquals(endMinutes + moveMin, ts.getEndTime().getMinutes());
    }


    @Test
    public void move_negative() throws Exception {
        int moveMin = -5;
        int beginMinutes = ts.getBeginTime().getMinutes();
        int endMinutes = ts.getEndTime().getMinutes();
        ts.move(moveMin);

        assertEquals(beginMinutes  + moveMin, ts.getBeginTime().getMinutes());
        assertEquals(endMinutes + moveMin, ts.getEndTime().getMinutes());
    }

    @Test
    public void changeLengthWith() throws Exception {
        int moveMin = 5;
        int endMinutes = ts.getEndTime().getMinutes();
        ts.changeLengthWith(moveMin);

        assertEquals(endMinutes + moveMin, ts.getEndTime().getMinutes());
    }


    @Test(expected = IllegalArgumentException.class)
    public void changeLengthWith_IllegalArgument() throws Exception {
        int moveMin = -5;
        int endMinutes = ts.getEndTime().getMinutes();
        ts.changeLengthWith(moveMin);
    }

    @Test
    public void isPartOf() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 3, 5, 14, 5),
                new Time(2020, 3, 5, 14, 10));
        assertTrue(ts.isPartOf(span));
    }


    @Test
    public void isNotPartOf() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 3, 5, 14, 5),
                new Time(1992, 3, 5, 14, 10));
        assertFalse(ts.isPartOf(span));
    }

    @Test
    public void unionWith_Begin() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 1, 1, 1, 1),
                new Time(1995, 3, 31, 15, 50));
        ITimeSpan newSpan = ts.unionWith(span);

        assertEquals(5, newSpan.length());
    }

    @Test
    public void unionWith_End() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(2017, 4, 1, 15, 40),
                new Time(2020, 3, 31, 15, 50));
        ITimeSpan newSpan = ts.unionWith(span);

        assertEquals(5, newSpan.length());
    }

    @Test
    public void unionWith_spanWithinTs() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1995, 3, 31, 15, 50),

                new Time(2017, 4, 1, 15, 40));
        ITimeSpan newSpan = ts.unionWith(span);

        assertEquals(span.length(), newSpan.length());
    }

    @Test
    public void unionWith_TsWithinSpan() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 3, 31, 15, 50),

                new Time(2020, 4, 1, 15, 40));
        ITimeSpan newSpan = ts.unionWith(span);

        assertEquals(ts.length(), newSpan.length());
    }

    @Test
    public void unionWith_NoUnion() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 1, 1, 1, 1),
                new Time(1990, 3, 31, 15, 50));
        ITimeSpan newSpan = ts.unionWith(span);

        assertEquals(null, newSpan);
    }

    @Test
    public void intersectionWith_TestWithinNew() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1995, 3, 31, 15, 10),
                new Time(2017, 4, 1, 15, 55));
        ITimeSpan newSpan = ts.intersectionWith(span);

        assertEquals(span.length(), newSpan.length());
    }

    @Test
    public void intersectionWith_NewWithinTest() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1997, 3, 31, 15, 10),
                new Time(2016, 4, 1, 15, 55));
        ITimeSpan newSpan = ts.intersectionWith(span);

        assertEquals(ts.length(), newSpan.length());
    }

    @Test
    public void intersectionWith_NoIntersection() throws Exception {
        TimeSpan span =  new TimeSpan(
                new Time(1990, 1, 1, 1, 1),
                new Time(1990, 3, 31, 15, 50));
        ITimeSpan newSpan = ts.intersectionWith(span);

        assertEquals(null, newSpan);
    }

}