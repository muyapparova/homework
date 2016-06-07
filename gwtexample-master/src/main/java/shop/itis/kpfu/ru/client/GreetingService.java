package shop.itis.kpfu.ru.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

@RemoteServiceRelativePath("springGwtServices/greetingService")
public interface GreetingService extends RemoteService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String greet(String name);
}
