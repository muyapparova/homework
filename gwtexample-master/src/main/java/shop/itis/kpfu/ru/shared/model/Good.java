package shop.itis.kpfu.ru.shared.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eljah32 on 4/14/2016.
 */

@Entity
@Table(name = "users")
public class Good implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private Boolean bought=false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }
}
