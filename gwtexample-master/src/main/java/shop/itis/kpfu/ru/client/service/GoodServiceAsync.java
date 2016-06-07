package shop.itis.kpfu.ru.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.springframework.scheduling.annotation.Async;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */
public interface GoodServiceAsync {

    void addGood(Good good, AsyncCallback<String> callback);

    void buyGood(long id, AsyncCallback<Void> async);

    void getAllGoods(AsyncCallback<List<Good>> async);
}
