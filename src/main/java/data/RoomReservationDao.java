package data;


import model.RoomReservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RoomReservationDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(RoomReservation roomReservation){
        // open session
        Session session = sessionFactory.openSession();
        // begin a criteria
        session.beginTransaction();
        //use the session to save the contact
        session.save(roomReservation);
        // create list of contact
        session.getTransaction().commit();
        // close the session
        session.close();
    }
    public Integer getMaxReserveNumber(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder =session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<RoomReservation> root = criteriaQuery.from(RoomReservation.class);
        criteriaQuery.select(criteriaBuilder.max(root.get("reserveCode")));
        Query query =session.createQuery(criteriaQuery);
        Integer reserveCode = (Integer) query.getSingleResult();
        session.close();
        return reserveCode;
    }

    public static int  update(RoomReservation roomReservation){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query = session.createQuery(
                "update model.RoomReservation as c set c.name = :c_name, c.lastName = :c_lastName, c.nationalCode=:c_nationalCode, c.capacity = :c_capacity, c.startDate = :c_startDate, c.endDate = :c_endDate where c.reserveCode = :c_reserveCode")
                .setParameter("c_name", roomReservation.getName())
                .setParameter("c_lastName", roomReservation.getLastName())
                .setParameter("c_nationalCode", roomReservation.getNationalCode())
                .setParameter("c_capacity", roomReservation.getCapacity())
                .setParameter("c_startDate", roomReservation.getStartDate())
                .setParameter("c_endDate", roomReservation.getEndDate())
                .setParameter("c_reserveCode", roomReservation.getReserveCode());
        int countUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        return countUpdate;
    }
    public static RoomReservation fetchReserveByReserveCode(int reserveCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.RoomReservation as c  where c.reserveCode= :c_reserveCode")
                .setParameter("c_reserveCode",reserveCode);

        RoomReservation roomReservation = (RoomReservation) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return roomReservation;
    }
    public static List<RoomReservation> fetchRoomReserve(String nationalCode){
        Session session = sessionFactory.openSession();
        //List<Contact> contacts = session.createQuery("from ir.maktab.model.Contact as c  where c.id>=3").list();
        List<RoomReservation> roomReservations = session.createQuery("from model.RoomReservation as c  where c.nationalCode = :c_nationalCode").setParameter("c_nationalCode",nationalCode).list();
        session.close();
        return roomReservations;
    }
    public static int  delete(int roomReservationCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query = session.createQuery(
                "delete model.RoomReservation as c where c.reserveCode = :c_reserveCode")
                .setParameter("c_reserveCode", roomReservationCode);
        int countUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        return countUpdate;
    }

   /* public static void main(String[] args) {

    }*/
}

