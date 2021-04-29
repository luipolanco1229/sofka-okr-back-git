package co.com.sofka.okrs.domain.notificationsDomain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notifications {

        String id;
        String userId;
        String notificationDescription;
        String okrId;
        String krId;
        Boolean viewed;




}
