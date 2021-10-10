package ir.maktab.model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.maktab.model.CustomLocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedulePOJO {

    private Long id;

    private String flightNumber;

    private String destination;

    private String source;

    private String price;

    private String airline;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime time;

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "destination='" + destination + '\'' +
                ", source='" + source + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
