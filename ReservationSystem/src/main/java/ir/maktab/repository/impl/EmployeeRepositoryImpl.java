package ir.maktab.repository.impl;

import ir.maktab.repository.EmployeeRepository;
import javax.persistence.EntityManagerFactory;

public class EmployeeRepositoryImpl extends UserRepositoryImpl  implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

}
