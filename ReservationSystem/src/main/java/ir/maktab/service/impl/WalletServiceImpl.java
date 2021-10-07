package ir.maktab.service.impl;

import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.model.Wallet;
import ir.maktab.repository.WalletRepository;
import ir.maktab.service.WalletService;

public class WalletServiceImpl extends BaseEntityServiceImpl<Wallet, Long, WalletRepository> implements WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }
}
