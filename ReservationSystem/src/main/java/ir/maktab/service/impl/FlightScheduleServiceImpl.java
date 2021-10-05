package ir.maktab.service.impl;

import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.model.FlightSchedule;
import ir.maktab.repository.FlightScheduleRepository;
import ir.maktab.service.FlightScheduleService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FlightScheduleServiceImpl extends BaseEntityServiceImpl<FlightSchedule, Long, FlightScheduleRepository>
                        implements FlightScheduleService {

    public FlightScheduleServiceImpl(FlightScheduleRepository repository) {
        super(repository);
    }

    @Override
    public List<FlightSchedule> findAllBySourceAndDestination(String source, String destination) {
        EntityManager em = repository.getEntityManager();
        try {
            return repository.findAllBySourceAndDestination(source, destination);
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
