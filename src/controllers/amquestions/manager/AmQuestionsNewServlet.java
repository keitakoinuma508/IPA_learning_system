package controllers.amquestions.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AmQuestion;

/**
 * Servlet implementation class AmQuestionsNewServlet
 */
@WebServlet("/amquestions/manager/new")
public class AmQuestionsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmQuestionsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token",request.getSession().getId());
        request.setAttribute("amquestion",new AmQuestion());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/amquestions/new.jsp");
        rd.forward(request,response);
    }

}
