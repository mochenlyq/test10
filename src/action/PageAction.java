package action;

import Service.PageService;
import Service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
import javaBean.PageBean;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class PageAction extends ActionSupport {

    private PageService pageService = new StudentService();

    private int page;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    @Override
    public String execute() throws Exception
    {
        //表示每页显示 5 条记录，page表示当前网页
        PageBean pageBean = pageService.getPageBean(5, page);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }

}
