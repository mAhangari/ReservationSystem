package ir.maktab.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Coupon.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Coupon extends BaseEntity<Long> {

    public static final String TABLE_NAME = "coupon_table";
    private static final String COUPON_CODE = "coupon_code";
    private static final String EXPIRE_DATE = "expire_date";
    private static final String OFF_PERCENTAGE = "off_percentage";

    @Column(name = COUPON_CODE, nullable = false, unique = true)
    private String couponCode;

    @Column(name = EXPIRE_DATE, nullable = false)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime expireDate;

    @Column(name = OFF_PERCENTAGE, nullable = false)
    private int percentage;

}
