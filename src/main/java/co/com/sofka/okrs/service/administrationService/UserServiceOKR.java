package co.com.sofka.okrs.service.administrationService;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceOKR {
    @Autowired
    private UserRepository repository;

    public Mono<User> save(User user){
        return repository.save(user);
    }
}
