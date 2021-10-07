package ir.maktab.repository.impl;

import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.model.Wallet;
import ir.maktab.repository.WalletRepository;

import javax.persistence.EntityManagerFactory;

public class WalletRepositoryImpl extends BaseEntityRepositoryImpl<Wallet, Long> implements WalletRepository {

    public WalletRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}
