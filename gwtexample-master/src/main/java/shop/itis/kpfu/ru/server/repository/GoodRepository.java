package shop.itis.kpfu.ru.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.itis.kpfu.ru.shared.model.Good;

/**
 * Created by eljah32 on 4/15/2016.
 */
@Repository
public interface GoodRepository  extends JpaRepository<Good, Long> {

    Good findOneByName(String username);

    Good findOneById(long id);
}
