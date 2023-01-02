package com.repository;

import com.domain.Amount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AmountRepositoryImpl implements AmountRepository {
    private SessionFactory sessionFactory;

    public AmountRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Amount> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Amount> userQuery = session.createQuery("from TaxVariables", Amount.class);
        return userQuery.getResultList();
    }

    public Amount create(Amount taxVariables) {
        Session session = sessionFactory.getCurrentSession();
        session.save(taxVariables);
        return taxVariables;
    }

    public Amount get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Amount.class, id);
    }

    public Amount update(Amount taxVariables) {
        Session session = sessionFactory.getCurrentSession();
        session.update(taxVariables);
        return taxVariables;
    }
}
