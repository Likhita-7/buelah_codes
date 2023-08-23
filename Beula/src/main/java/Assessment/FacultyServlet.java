package Assessment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacultyServlet extends HttpServlet {
    private FacultyDAO facultyDAO;

    public void init() {
        facultyDAO = new FacultyDAOimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addFaculty(request, response);
                    break;
                case "update":
                    updateFaculty(request, response);
                    break;
                case "delete":
                    deleteFaculty(request, response);
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("read")) {
            readFaculties(request, response);
        }
    }

    private void addFaculty(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve faculty details from request parameters
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dateOfJoining = request.getParameter("date_of_joining");

        // Create a new Faculty object
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setDesignation(designation);
        faculty.setDepartment(department);
        faculty.setEmail(email);
        faculty.setPhone(phone);
        faculty.setDateOfJoining(dateOfJoining);

        // Add faculty to the database
        facultyDAO.addFaculty(faculty);

        // Redirect to the HTML page or send a success response
        response.sendRedirect("index.html");
    }

    private void updateFaculty(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve faculty details from request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dateOfJoining = request.getParameter("date_of_joining");

        // Create a
        // Create a Faculty object with updated details
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setDesignation(designation);
        faculty.setDepartment(department);
        faculty.setEmail(email);
        faculty.setPhone(phone);
        faculty.setDateOfJoining(dateOfJoining);

        // Update faculty in the database
        facultyDAO.updateFaculty(faculty);

        // Redirect to the HTML page or send a success response
        response.sendRedirect("index.html");
    }

    private void deleteFaculty(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve faculty ID from request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete faculty from the database
        facultyDAO.deleteFaculty(id);

        // Redirect to the HTML page or send a success response
        response.sendRedirect("index.html");
    }

    private void readFaculties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all faculties from the database
        List<Faculty> faculties = facultyDAO.getAllFaculties();

        // Set faculties as an attribute in the request object
        request.setAttribute("faculties", faculties);

        // Forward the request to the HTML page for rendering
        request.getRequestDispatcher("faculty.jsp").forward(request, response);
    }
}
