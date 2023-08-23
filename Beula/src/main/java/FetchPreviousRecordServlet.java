import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FetchPreviousRecordServlet")
public class FetchPreviousRecordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        int currentId = Integer.parseInt(request.getParameter("id"));

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "SELECT * FROM Employee WHERE id < ? ORDER BY id DESC LIMIT 1";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, currentId);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	 Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));

             
                response.getWriter().print(rs.getInt(1)+","+rs.getString("first_name")+","+rs.getString("last_name")+","+rs.getString("email"));
            } else {
                
                out.print("{}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
    }

  

    // Helper method to close database resources
    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

