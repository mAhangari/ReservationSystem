package ir.maktab.repository.impl;

import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.model.Airline;
import ir.maktab.model.FlightSchedule;
import ir.maktab.repository.FlightScheduleRepository;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class FlightScheduleRepositoryImpl extends BaseEntityRepositoryImpl<FlightSchedule, Long>
        implements FlightScheduleRepository {

    public FlightScheduleRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<FlightSchedule> getEntityClass() {
        return null;
    }

    @Override
    public List<FlightSchedule> findAllBySourceAndDestination(String source, String destination,
                                                              Long maxPrice, Airline airlineId) {
        if (maxPrice != null && airlineId != null)
            return em.createQuery(
                    "FROM FlightSchedule f " +
                            "WHERE f.source =: source " +
                            "AND f.destination =: destination " +
                            "AND CAST(f.price AS long) <: maxPrice " +
                            "AND f.airline =: airline",
                    FlightSchedule.class)
                    .setParameter("source", source)
                    .setParameter("destination", destination)
                    .setParameter("maxPrice", maxPrice)
                    .setParameter("airline", airlineId)
                    .getResultList();
        else if (maxPrice == null && airlineId == null)
            return findAllBySourceAndDestination(source, destination);
        else if (maxPrice == null)
            return findAllBySourceAndDestination(source, destination, airlineId);
        else return findAllBySourceAndDestination(source, destination, maxPrice);
    }

    private List<FlightSchedule> findAllBySourceAndDestination(String source, String destination, Airline airlineId) {
        return em.createQuery(
                        "FROM FlightSchedule f " +
                                "WHERE f.source =: source " +
                                "AND f.destination =: destination " +
                                "AND f.airline =: airline",
                        FlightSchedule.class)
                .setParameter("source", source)
                .setParameter("destination", destination)
                .setParameter("airline", airlineId)
                .getResultList();
    }

    private List<FlightSchedule> findAllBySourceAndDestination(String source, String destination, Long maxPrice) {
        return em.createQuery(
                        "FROM FlightSchedule f " +
                                "WHERE f.source =: source " +
                                "AND f.destination =: destination " +
                                "AND CAST(f.price AS long) <: maxPrice ",
                        FlightSchedule.class)
                .setParameter("source", source)
                .setParameter("destination", destination)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }

    private List<FlightSchedule> findAllBySourceAndDestination(String source, String destination) {
        return em.createQuery(
                        "FROM FlightSchedule f " +
                                "WHERE f.source =: source " +
                                "AND f.destination =: destination ",
                        FlightSchedule.class)
                .setParameter("source", source)
                .setParameter("destination", destination)
                .getResultList();
    }
}
