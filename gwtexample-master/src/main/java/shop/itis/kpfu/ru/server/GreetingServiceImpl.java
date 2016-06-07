package shop.itis.kpfu.ru.server;

import org.springframework.security.access.prepost.PreAuthorize;
import shop.itis.kpfu.ru.client.GreetingService;
import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
