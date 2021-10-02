package ir.maktab.repository;

import ir.baseCRUD.base.repository.BaseEntityRepository;
import ir.maktab.domain.User;

public interface BaseUserRepository<E extends User, UT, PT> extends BaseEntityRepository<E, Long> {

    E findUserByUsername(UT username);

    Boolean existsByUsernameAndPassword(UT username, PT password);

    Boolean existsByUsername(UT username);
}
