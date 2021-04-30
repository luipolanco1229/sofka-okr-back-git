package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotificationConfigurationService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> ConsultConfig (String email){
        Flux<User> users = userRepository.findAll();

        return users.filter(user1 -> user1.getEmail().equals(email));
    }

    public Mono<User> InsertConfig (User user){
        userRepository.insert(user);
        return Mono.empty();
    }



}
