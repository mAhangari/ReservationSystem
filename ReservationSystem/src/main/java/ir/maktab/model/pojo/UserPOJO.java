package ir.maktab.model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.maktab.model.CustomLocalDateTimeSerializer;
import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPOJO {

    private String firstName;

    private String lastName;

    private String username;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime birthDate;

    private String nationalCode;
}
