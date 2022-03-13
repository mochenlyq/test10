package Service;

import dao.*;
import javaBean.PageBean;
import javaBean.Student;

import java.util.List;

public class StudentService implements PageService {

    private BaseDAO baseDAO = new PageDAO();

    @Override
    public PageBean getPageBean(int pageSize, int page) { //pageSize = 5

        PageBean pageBean = new PageBean();

        //查询Student类表的所以行，得到总记录数allRows
        String hql = "from Student";
        int allRows = baseDAO.getAllRowCount(hql);
        //以每 5 行分一页，记算所以行的总页数totalPage
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        //计算得到 当前页数currentPage
        int currentPage = pageBean.getCurPage(page);
        //计算得到得到当前开始记录号offset，并进行分页查询
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = baseDAO.queryByPage(hql, offset, pageSize);

        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);

        return pageBean;

    }

}
