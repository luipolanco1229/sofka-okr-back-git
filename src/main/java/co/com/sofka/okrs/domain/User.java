package co.com.sofka.okrs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    
    private Boolean mailCompletedOkr;

    private Boolean mailCompletedKr;

    private Boolean notificationCompletedKr;

    private Boolean notificationCompletedOkr;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mailCompletedOkr = true;
        this.mailCompletedKr = true;
        this.notificationCompletedKr = true;
        this.notificationCompletedOkr = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMailCompletedOkr() {
        return mailCompletedOkr;
    }

    public void setMailCompletedOkr(Boolean mailCompletedOkr) {
        this.mailCompletedOkr = mailCompletedOkr;
    }

    public Boolean getMailCompletedKr() {
        return mailCompletedKr;
    }

    public void setMailCompletedKr(Boolean mailCompletedKr) {
        this.mailCompletedKr = mailCompletedKr;
    }

    public Boolean getNotificationCompletedKr() {
        return notificationCompletedKr;
    }

    public void setNotificationCompletedKr(Boolean notificationCompletedKr) {
        this.notificationCompletedKr = notificationCompletedKr;
    }

    public Boolean getNotificationCompletedOkr() {
        return notificationCompletedOkr;
    }

    public void setNotificationCompletedOkr(Boolean notificationCompletedOkr) {
        this.notificationCompletedOkr = notificationCompletedOkr;
    }

}
