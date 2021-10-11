package ir.maktab.repository;

import ir.baseCRUD.base.repository.BaseEntityRepository;
import ir.maktab.model.Coupon;

public interface CouponRepository extends BaseEntityRepository<Coupon, Long> {

    boolean existsByCouponCode(String couponCode);

    Coupon findByCouponCode(String couponCode);
}
