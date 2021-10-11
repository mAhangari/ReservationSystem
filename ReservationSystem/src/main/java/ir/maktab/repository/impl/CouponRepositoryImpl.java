package ir.maktab.repository.impl;

import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.model.Coupon;
import ir.maktab.repository.CouponRepository;

import javax.persistence.EntityManagerFactory;

public class CouponRepositoryImpl extends BaseEntityRepositoryImpl<Coupon, Long> implements CouponRepository {

    public CouponRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<Coupon> getEntityClass() {
        return Coupon.class;
    }

    @Override
    public boolean existsByCouponCode(String couponCode) {
        return em.createQuery("SELECT COUNT(c.couponCode)" +
                " FROM Coupon c" +
                " WHERE c.expireDate > CURRENT_TIMESTAMP" +
                " AND c.couponCode =: couponCode",
                Long.class)
                .setParameter("couponCode", couponCode)
                .getSingleResult() == 1L;
    }

    @Override
    public Coupon findByCouponCode(String couponCode) {
        return em.createQuery("FROM Coupon c " +
                "WHERE c.expireDate > CURRENT_TIMESTAMP " +
                "AND c.couponCode =: couponCode ",
                Coupon.class)
                .setParameter("couponCode", couponCode)
                .getSingleResult();
    }
}
