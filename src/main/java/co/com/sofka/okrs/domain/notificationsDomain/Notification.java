package co.com.sofka.okrs.domain.notificationsDomain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Notification {

        @Id
        String id;
        String userId;
        String notificationDescription;
        String okrId;
        String krId;
        Boolean viewed;

        public Notification(String id, String userId, String notificationDescription, String okrId, String krId, Boolean viewed) {
                this.id = id;
                this.userId = userId;
                this.notificationDescription = notificationDescription;
                this.okrId = okrId;
                this.krId = krId;
                this.viewed = viewed;
        }

        public Notification(String id, String userId, String notificationDescription, String okrId, Boolean viewed) {
                this.id = id;
                this.userId = userId;
                this.notificationDescription = notificationDescription;
                this.okrId = okrId;
                this.viewed = viewed;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getNotificationDescription() {
                return notificationDescription;
        }

        public void setNotificationDescription(String notificationDescription) {
                this.notificationDescription = notificationDescription;
        }

        public String getOkrId() {
                return okrId;
        }

        public void setOkrId(String okrId) {
                this.okrId = okrId;
        }

        public String getKrId() {
                return krId;
        }

        public void setKrId(String krId) {
                this.krId = krId;
        }

        public Boolean getViewed() {
                return viewed;
        }

        public void setViewed(Boolean viewed) {
                this.viewed = viewed;
        }
}
