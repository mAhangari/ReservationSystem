package ir.maktab.model;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = Wallet.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet_table";
    private static final String CUSTOMER_ID = "customer_id";
    private static final String TOTAL_AMOUNT = "total_amount";
    private static final String CREDIT_AMOUNT = "credit_amount";
    private static final String CASH_AMOUNT = "cash_amount";

    @OneToOne
    @JoinColumn(name = CUSTOMER_ID, unique = true, nullable = false)
    private Customer customer;

    @Column(name = TOTAL_AMOUNT)
    private Long totalAmount = 0L;

    @Column(name = CREDIT_AMOUNT)
    private Long creditAmount = 0L;

    @Column(name = CASH_AMOUNT)
    private Long cashAmount = 0L;

}
