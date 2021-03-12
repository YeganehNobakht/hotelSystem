package data;

import model.RoomReservation;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(RoomReservation.class);
            configuration.setProperties(new Properties(){
                {
                    put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
                    put("hibernate.connection.url","jdbc:mysql://localhost:3306/hotel_reservation");
                    put("hibernate.connection.username","root");
                    put("hibernate.connection.password","root");
                    put("hibernate.hbm2ddl.auto","create-drop");
                    put("hibernate.show_sql","true");
                }

            });

            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

