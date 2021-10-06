package ir.maktab.repository.impl;

import ir.maktab.repository.CustomerRepository;
import javax.persistence.EntityManagerFactory;

public class CustomerRepositoryImpl extends UserRepositoryImpl implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
