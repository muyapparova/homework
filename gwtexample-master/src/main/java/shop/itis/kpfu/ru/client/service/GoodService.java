package shop.itis.kpfu.ru.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.springframework.stereotype.Service;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */

@RemoteServiceRelativePath("springGwtServices/goodService")
public interface GoodService  extends RemoteService {

    void buyGood(long id);

    List<Good> getAllGoods();

    String addGood(Good good);
}
