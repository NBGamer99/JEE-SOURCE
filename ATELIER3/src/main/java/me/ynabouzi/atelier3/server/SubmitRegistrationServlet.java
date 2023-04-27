package me.ynabouzi.atelier3.server;

import me.ynabouzi.atelier3.controllers.SubmitRegistrationEJB;
import me.ynabouzi.atelier3.entities.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SubmitRegistration", value = "/register")

public class SubmitRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public SubmitRegistrationServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a student object from the data submited from the form.
        Student student = new Student();
        student.setLastName(request.getParameter("lastname"));
        student.setFirstName(request.getParameter("firstname"));
        student.setCIN(request.getParameter("CIN"));
        student.setEmail(request.getParameter("email"));
        student.setBirthDate(request.getParameter("birthdate"));
        student.setPhoneNumber(request.getParameter("Phone Number"));

        // Set an attribute to send it in an HTTP request to another JSP page
        request.setAttribute("student", student);

        // Create an instantiation of the EJB class
        SubmitRegistrationEJB JPA = new SubmitRegistrationEJB();

        // Call the methode registerStudent() to insert the student in the DB
        JPA.registerStudent(student);

        // Redirect to success.jsp with the result.
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
//        doGet(request, response);
    }
}
