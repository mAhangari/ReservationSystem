package ir.maktab.repository.impl;

import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.model.Airline;
import ir.maktab.repository.AirlineRepository;
import javax.persistence.EntityManagerFactory;

public class AirlineRepositoryImpl extends BaseEntityRepositoryImpl<Airline, Long> implements AirlineRepository {

    public AirlineRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<Airline> getEntityClass() {
        return Airline.class;
    }
}
