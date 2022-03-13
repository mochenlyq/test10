package dao;

import javaBean.Student;

import java.util.List;

public interface BaseDAO {

    public List<Student> queryByPage(String hql, int offset, int pageSize);

    public int getAllRowCount(String hql);
}
