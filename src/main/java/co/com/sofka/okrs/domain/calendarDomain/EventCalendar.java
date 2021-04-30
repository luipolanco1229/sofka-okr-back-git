package co.com.sofka.okrs.domain.calendarDomain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EventCalendar {
    public static EventCalendar DEFAULT_EVENT_CALENDAR = new EventCalendar("default", "event default", "colombia", LocalDate.now().toString(), "06:00:00", "12:00:00", List.of("thisaexample@gmail.com", "Sofka.OKR@gmail.com", "Sofka.OKR@gmail.com"));

    private String title;
    private String description;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private List<String> emails;

    public EventCalendar(String title, String description, String location, String date, String startTime, String endTime, List<String> emails) {
        this.title = Objects.requireNonNull(title, "title is required");
        this.description = Objects.requireNonNull(description, "description is required");;
        this.location = location;
        this.date = Objects.requireNonNull(date, "date is required in format: YYYY-MM-DD");
        this.startTime = Objects.requireNonNull(startTime, "startTime is required");
        this.endTime = Objects.requireNonNull(endTime, "endTime is required");
        this.emails = Objects.requireNonNull(emails, "emails are required");
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
