package co.com.sofka.okrs.service.notificationService;

import co.com.sofka.okrs.domain.User;
import co.com.sofka.okrs.repository.UserRepository;
import co.com.sofka.okrs.service.administrationService.UserServiceOKR;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.progress.ArgumentMatcherStorage;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationConfigurationServiceTest {


    @InjectMocks
    NotificationConfigurationService notificationConfigurationService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
         notificationConfigurationService = new NotificationConfigurationService();
    }

}