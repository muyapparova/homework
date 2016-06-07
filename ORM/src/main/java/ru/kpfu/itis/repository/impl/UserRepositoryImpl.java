package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        Query query = em.createNativeQuery("SELECT * FROM users", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserByLogin(String login) {
        Query query = em.createNativeQuery("SELECT * from users where login = ?");
        query.setParameter(1, login);
        return (User) query.getSingleResult();
    }

    @Override
    public User findUserById(Long id) {
        TypedQuery<User> query = (TypedQuery<User>) em.createNativeQuery("SELECT * FROM users WHERE id = ?", User.class);
        return query.setParameter(1, id).getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.persist(user);
    }
}
