package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.CourseDAO;
import javaBean.Course;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CourseAction extends ActionSupport {

    private int studentId;

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public int getCourseNo() {
        return courseNo;
    }

    private int courseNo;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String select() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        List<Course> list = courseDAO.select(studentId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list", list);
        request.setAttribute("stuId", getStudentId());
        return SUCCESS;
    }

    public String add() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        int result = courseDAO.add(studentId, courseNo);
        if (result == 1){
            return SUCCESS;
        }
        else return ERROR;

    }

    public String delete() throws Exception {
        CourseDAO courseDAO = new CourseDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Course> list = courseDAO.delete(studentId, courseNo);
        request.setAttribute("list", list);
        request.setAttribute("stuId", getStudentId());
        return SUCCESS;
    }
}
