package ir.maktab.service;

import ir.baseCRUD.base.service.BaseEntityService;
import ir.maktab.model.Airline;
import ir.maktab.model.FlightSchedule;
import java.util.List;

public interface FlightScheduleService extends BaseEntityService<FlightSchedule, Long> {

    List<FlightSchedule> findAllBySourceAndDestination(String source, String destination,
                                                       Long maxPrice, Airline airlineId);
}
