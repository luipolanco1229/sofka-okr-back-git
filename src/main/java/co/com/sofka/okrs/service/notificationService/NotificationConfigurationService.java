package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationConfigurationService {

    @Autowired
    UserRepository userRepository;

    public Mono<User> ConsultConfig (String id){
        return userRepository.findById(id);
    }

    public Mono<User> InsertConfig (User user){
        userRepository.insert(user);
        return Mono.empty();
    }



}
