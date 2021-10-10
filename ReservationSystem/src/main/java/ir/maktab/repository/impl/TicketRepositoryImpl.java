package ir.maktab.repository.impl;

import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.model.Ticket;
import ir.maktab.repository.TicketRepository;

import javax.persistence.EntityManagerFactory;

public class TicketRepositoryImpl extends BaseEntityRepositoryImpl<Ticket, Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
