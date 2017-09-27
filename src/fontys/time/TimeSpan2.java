package fontys.time;

public class TimeSpan2 implements ITimeSpan {

    private ITime bt;
    private long duration;

    public TimeSpan2(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.duration = et.difference(bt);
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        ITime et = bt;
        et.plus((int)duration);
        return et;
    }

    @Override
    public int length() {
        return (int)duration;
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        ITime et = bt;
        et.plus((int)duration);
        if (beginTime.compareTo(et) < 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        ITime et = bt;
        if (endTime.compareTo(bt) > 0) {
            throw new IllegalArgumentException("end time "
                    + et + " must be later then begin time " + bt);
        }

        duration = endTime.difference(bt);
    }

    @Override
    public void move(int minutes) {
        duration += minutes;
        bt = bt.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        duration += minutes;
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) < 0
                && getEndTime().compareTo(timeSpan.getEndTime()) > 0);
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        ITime et = bt;
        et.plus((int)duration);
        if (bt.compareTo(timeSpan.getEndTime()) <= 0 || et.compareTo(timeSpan.getBeginTime()) >= 0) {
            return null;
        }

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan(begintime, endtime);
    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        ITime et = bt;
        et.plus((int)duration);
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || timeSpan.getBeginTime().compareTo(et) < 0) {
            return null;
        }

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan(begintime, endtime);
    }
}
