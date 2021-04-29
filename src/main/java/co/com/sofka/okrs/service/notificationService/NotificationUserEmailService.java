package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.dto.dashboard_dto.UserView;
import co.com.sofka.okrs.repository.UserRepository;
import co.com.sofka.okrs.utils.dashboardUtils.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationUserEmailService {

    @Autowired
    private UserRepository userRepository;

    public Mono<UserView> userByIdAndEmail(String id){

        return userRepository.findById(id).map(Assembler::generateUserView)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User not found")));
    }


}
