package ir.maktab.service.impl;

import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.model.Coupon;
import ir.maktab.repository.CouponRepository;
import ir.maktab.service.CouponService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CouponServiceImpl extends BaseEntityServiceImpl<Coupon, Long, CouponRepository> implements CouponService {

    public CouponServiceImpl(CouponRepository repository) {
        super(repository);
    }

    @Override
    public boolean existsByCouponCode(String couponCode) {
        EntityManager em = repository.getEntityManager();
        try {
            return this.repository.existsByCouponCode(couponCode);
        } catch (NoResultException exception) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Coupon findByCouponCode(String couponCode) {
        EntityManager em = repository.getEntityManager();
        try {
            return this.repository.findByCouponCode(couponCode);
        } catch (NoResultException exception) {
            return null;
        } finally {
            em.close();
        }
    }
}
