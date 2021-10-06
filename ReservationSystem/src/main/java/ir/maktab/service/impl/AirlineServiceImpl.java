package ir.maktab.service.impl;

import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.model.Airline;
import ir.maktab.repository.AirlineRepository;
import ir.maktab.service.AirlineService;

public class AirlineServiceImpl extends BaseEntityServiceImpl<Airline, Long, AirlineRepository> implements AirlineService {

    public AirlineServiceImpl(AirlineRepository repository) {
        super(repository);
    }
}
