package hibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory sessionFactory;

    //创建线程变量
    public static final ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    //静态代码块
    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Throwable ex){
            System.out.println("失败" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session currentSession() throws HibernateException{
        Session s = sessions.get();
        if(s == null){
            s = sessionFactory.openSession();
            sessions.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException{
        Session s = sessions.get();
        if (s != null){
            s.close();
            sessions.set(null);
        }
    }
}
