package ir.maktab.model;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = Wallet.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet_table";
    private static final String TOTAL_AMOUNT = "total_amount";
    private static final String CREDIT_AMOUNT = "credit_amount";
    private static final String CASH_AMOUNT = "cash_amount";

    @Column(name = TOTAL_AMOUNT)
    @Setter(AccessLevel.NONE)
    private Long totalAmount = 0L;

    @Column(name = CREDIT_AMOUNT)
    private Long creditAmount = 0L;

    @Column(name = CASH_AMOUNT)
    private Long cashAmount = 0L;

    public void setCashAmount(Long cashAmount){
        this.cashAmount = cashAmount;
        this.totalAmount = this.cashAmount + this.creditAmount;
    }

    public void setCreditAmount(Long creditAmount){
        this.creditAmount = creditAmount;
        this.totalAmount = this.creditAmount + this.cashAmount;
    }

}
