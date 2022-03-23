package dao;

import hibernateUtil.HibernateUtil;
import javaBean.Course;
import javaBean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAO {

    public List<Course> select(int studentId) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        List<Course> list = null;
        try
        {
            transaction = session.beginTransaction();
            list =  session.createQuery(
                    "SELECT NEW Course (c.courseNo, c.courseName) FROM Course c LEFT JOIN c.students s WHERE s.id =" + studentId).list();
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return list;
    }

    public List<Course> delete(int studentId, int courseNo) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        List<Course> list = null;
        try
        {
            transaction = session.beginTransaction();
            Course course = session.load(Course.class, courseNo);
            Student student = session.load(Student.class, studentId);
            course.getStudents().remove(student);
            list =  session.createQuery(
                    "SELECT NEW Course (c.courseNo, c.courseName) FROM Course c LEFT JOIN c.students s WHERE s.id =" + studentId).list();
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return list;
    }

    public int add(int studentId, int courseNo) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        try
        {
            transaction = session.beginTransaction();
            Course course = session.load(Course.class, courseNo);
            Student student = session.load(Student.class, studentId);
            student.getCourses().add(course);
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            return 0;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return 1;
    }


}
