package co.com.sofka.okrs.repository;


import co.com.sofka.okrs.domain.notificationsDomain.Notification;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryNotification extends ReactiveMongoRepository<Notification, String> {




}
