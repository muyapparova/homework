package shop.itis.kpfu.ru.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface GreetingServiceAsync {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void greet(String name, AsyncCallback<String> callback);
}