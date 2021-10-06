package ir.maktab.repository;

import ir.baseCRUD.base.repository.BaseEntityRepository;
import ir.maktab.model.Airline;
import ir.maktab.model.FlightSchedule;
import java.util.List;

public interface FlightScheduleRepository extends BaseEntityRepository<FlightSchedule, Long> {

    List<FlightSchedule> findAllBySourceAndDestination(String source, String destination,
                                                       Long maxPrice, Airline airlineId);
}
