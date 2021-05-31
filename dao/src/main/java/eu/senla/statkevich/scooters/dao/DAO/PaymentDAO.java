package eu.senla.statkevich.scooters.dao.DAO;

import eu.senla.statkevich.scooters.dao.IDao.IPaymentDao;
import eu.senla.statkevich.scooters.entity.entities.Payment;
import eu.senla.statkevich.scooters.entity.entities.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class PaymentDAO extends GenericDaoImpl<Payment> implements IPaymentDao {
    @Override
    public Payment create(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    @Override
    public List<Payment> readAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
        Root<Payment> paymentRoot = cq.from(Payment.class);

        CriteriaQuery<Payment> all = cq.select(paymentRoot);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public List<Payment> getByUser(Users user) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
        Root<Payment> paymentRoot = cq.from(Payment.class);

        Predicate userById = cb.equal(paymentRoot.get("user"), user.getId());
        cq.where(userById);

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Payment> getFreePayment(Users user, BigDecimal sum) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
        Root<Payment> paymentRoot = cq.from(Payment.class);


        Predicate[] predicates = new Predicate[3];
        predicates[0] = cb.equal(paymentRoot.get("user"), user.getId());
        predicates[1] = cb.equal(paymentRoot.get("sum"), sum);
        predicates[2] = cb.isNull(paymentRoot.get("rent"));

        cq.select(paymentRoot).where(predicates);

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Payment updateRentId(Payment payment) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Payment> criteriaUpdate = cb.createCriteriaUpdate(Payment.class);
        Root<Payment> root = criteriaUpdate.from(Payment.class);

        criteriaUpdate.set("rent", payment.getRent());
        criteriaUpdate.where(cb.equal(root.get("id"), payment.getId()));

        entityManager.createQuery(criteriaUpdate).executeUpdate();

        return payment;
    }
}
