package co.com.sofka.okrs.service.administrationService;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class UserServiceOKR {
    @Autowired
    private UserRepository repository;

    public Mono<User> save(User user){
        Mono<User> user1 = repository.findById(user.getId());
        return repository.save(Objects.requireNonNull(user));
    }
}
