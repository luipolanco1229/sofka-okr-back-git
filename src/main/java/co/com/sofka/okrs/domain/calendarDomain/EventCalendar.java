package co.com.sofka.okrs.domain.calendarDomain;

import java.util.List;

public class EventCalendar {
    private String title;
    private String description;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private List<String> emails;

    public EventCalendar(String title, String description, String location, String date, String startTime, String endTime, List<String> emails) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.emails = emails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String buildDateStart(){
        return date +"T"+ startTime +"-05:00";
    }
    public String buildDateEnd(){
        return date +"T"+ endTime +"-05:00";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
