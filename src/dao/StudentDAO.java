package dao;

import hibernateUtil.HibernateUtil;
import javaBean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public int alterStudent(Integer id, String name, String sex) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        int result = 0;
        try
        {
            transaction = session.beginTransaction();
            Student student = session.load(Student.class, id);
            student.setName(name);
            student.setSex(sex);
            transaction.commit();
            result = 1;
        }
        catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
            return result;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return result;
    }

}
