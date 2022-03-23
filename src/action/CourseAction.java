package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.CourseDAO;
import dao.StudentDAO;
import javaBean.Course;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CourseAction extends ActionSupport {

    private int courseNo;
    private Stu stu;

    public void setStu(Stu stu) { this.stu = stu; }

    public Stu getStu() { return stu; }

    public void setCourseNo(int courseNo) { this.courseNo = courseNo; }

    public int getCourseNo() {
        return courseNo;
    }


    public String select() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        List<Course> list = courseDAO.select(stu.getId());
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list", list);
        request.setAttribute("student", stu);
        return SUCCESS;
    }

    public String add() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        int result = courseDAO.add(stu.getId(), courseNo);
        if (result == 1){
            return SUCCESS;
        }
        else return ERROR;

    }

    public String delete() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Course> list = courseDAO.delete(stu.getId(), courseNo);
        request.setAttribute("list", list);
        request.setAttribute("stu", stu);
        return SUCCESS;
    }

    public String alters() throws Exception {
        System.out.println("传递的数值："+stu.getId() + " " + stu.getName() + " " + stu.getSex());
        StudentDAO studentDAO = new StudentDAO();
        int result = studentDAO.alterStudent(stu.getId(), stu.getName(), stu.getSex());
        if (result == 1){
            return SUCCESS;
        }
        else return ERROR;
    }
}
