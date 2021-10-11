package ir.maktab.service;

import ir.baseCRUD.base.service.BaseEntityService;
import ir.maktab.model.Coupon;

public interface CouponService extends BaseEntityService<Coupon, Long> {

    boolean existsByCouponCode(String couponCode);

    Coupon findByCouponCode(String couponCode);
}
