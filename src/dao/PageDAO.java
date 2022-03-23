package dao;

import hibernateUtil.HibernateUtil;
import javaBean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PageDAO implements BaseDAO {


    //分页查询，从 offset 行开始查询并最多查询 5行记录
    @Override
    public List<Student> queryByPage(String hql, int offset, int pageSize) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        List<Student> list = null;
        try
        {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
            list = query.list();
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

    //得到总页数
    @Override
    public int getAllRowCount(String hql) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        int allRows = 0;
        try
        {
            transaction= session.beginTransaction();
            Query query = session.createQuery(hql);
            allRows = query.list().size();
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
        return allRows;
    }

}
