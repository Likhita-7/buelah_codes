package Assessment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOimpl implements FacultyDAO {
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database_name";
//    private static final String DB_USER = "your_username";
//    private static final String DB_PASSWORD = "your_password";
   

	String s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
    @Override
    public void addFaculty(Faculty faculty) {
        try (Connection conn = DriverManager.getConnection(s)) {
            String query = "INSERT INTO faculty (name, designation, department, email, phone, date_of_joining) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, faculty.getName());
            statement.setString(2, faculty.getDesignation());
            statement.setString(3, faculty.getDepartment());
            statement.setString(4, faculty.getEmail());
            statement.setString(5, faculty.getPhone());
            statement.setString(6, faculty.getDateOfJoining());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFaculty(int id) {
        try (Connection conn = DriverManager.getConnection(s)) {
            String query = "DELETE FROM faculty WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        try (Connection conn = DriverManager.getConnection(s)) {
            String query = "UPDATE faculty SET name = ?, designation = ?, department = ?, email = ?, phone = ?, date_of_joining = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, faculty.getName());
            statement.setString(2, faculty.getDesignation());
            statement.setString(3, faculty.getDepartment());
            statement.setString(4, faculty.getEmail());
            statement.setString(5, faculty.getPhone());
            statement.setString(6, faculty.getDateOfJoining());
            statement.setInt(7, faculty.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Faculty getFacultyById(int id) {
        Faculty faculty = null;
        try (Connection conn = DriverManager.getConnection(s)) {
            String query = "SELECT * FROM faculty WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                faculty = new Faculty();
                faculty.setId(resultSet.getInt("id"));
                faculty.setName(resultSet.getString("name"));
                faculty.setDesignation(resultSet.getString("designation"));
                faculty.setDepartment(resultSet.getString("department"));
                faculty.setEmail(resultSet.getString("email"));
                faculty.setPhone(resultSet.getString("phone"));
                faculty.setDateOfJoining(resultSet.getString("date_of_joining"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(s)) {
            String query = "SELECT * FROM faculty";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(resultSet.getInt("id"));
                faculty.setName(resultSet.getString("name"));
                faculty.setDesignation(resultSet.getString("designation"));
                faculty.setDepartment(resultSet.getString("department"));
                faculty.setEmail(resultSet.getString("email"));
                faculty.setPhone(resultSet.getString("phone"));
                faculty.setDateOfJoining(resultSet.getString("date_of_joining"));
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }
}

