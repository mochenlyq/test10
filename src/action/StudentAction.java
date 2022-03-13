package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StudentDAO;
import javaBean.Student;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentAction extends ActionSupport {
    private Integer id;

    private String sex;

    private String name;

    public String alter() throws Exception {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println(id);
        System.out.println(name);
        System.out.println(sex);
        int result = studentDAO.alterStudent(id, name, sex);
        if (result == 1){
            return SUCCESS;
        }
        else return ERROR;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

}
