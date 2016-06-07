package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "siteName")
    private String siteName;

    @Column(name = "url")
    private String url;

//    private long userId;

    public Bookmark() {
    }

    public Bookmark(String siteName, String url) {
        this.siteName = siteName;
        this.url = url;
    }

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
