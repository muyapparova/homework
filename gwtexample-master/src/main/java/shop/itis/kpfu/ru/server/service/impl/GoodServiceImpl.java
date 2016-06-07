package shop.itis.kpfu.ru.server.service.impl;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shop.itis.kpfu.ru.server.AccessDenyException;
import shop.itis.kpfu.ru.server.repository.GoodRepository;
import shop.itis.kpfu.ru.client.service.GoodService;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService{
    @Autowired
    GoodRepository goodRepository;


    @Override
    @Secured("hasRole('ROLE_ADMIN')")
    public String addGood(Good good) {
        //good.setName("asda");
        goodRepository.save(good); return good.getName();
    }

    @Override
    public void buyGood(long id) {
        Good good=goodRepository.findOneById(id);
        good.setBought(true);
        goodRepository.save(good);
    }
    @Secured("{\"ROLE_USER\",\"ROLE_ADMIN\"}")
    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @ExceptionHandler(AccessDenyException.class)
    public String accessDeny() {
        return "access-deny";
    }
}
