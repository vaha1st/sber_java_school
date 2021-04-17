package course.homeworks.hw6;

import java.util.Date;

public class LogElement {
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private int eventNum;
    private Status status;

    public LogElement() {
    }

    public LogElement(String ip, String user, Date date, Event event, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public LogElement(String ip, String user, Date date, Event event, int eventNum, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.eventNum = eventNum;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String eventNum = (getEventNum() == 0) ? "" : String.valueOf(getEventNum());
        return "IP: " + getIp() + " User: " + getUser() + " Date: " + getDate().toString()
                + " Event" + eventNum + ": " + getEvent().name() + " Status: " + getStatus().name();
    }
}