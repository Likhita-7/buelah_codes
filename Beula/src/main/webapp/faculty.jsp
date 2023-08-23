<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty List</title>
</head>
<body>
    <h1>Faculty List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Department</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Date of Joining</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${faculties}" var="faculty">
                <tr>
                    <td>${faculty.id}</td>
                    <td>${faculty.name}</td>
                    <td>${faculty.designation}</td>
                    <td>${faculty.department}</td>
                    <td>${faculty.email}</td>
                    <td>${faculty.phone}</td>
                    <td>${faculty.dateOfJoining}</td>
                    <td>
                        <button onclick="deleteFaculty(${faculty.id})">Delete</button>
                        <button onclick="editFaculty(${faculty.id})">Edit</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        // Function to handle delete faculty action
        function deleteFaculty(id) {
            $.ajax({
                url: "FacultyServlet?action=delete",
                type: "POST",
                data: {
                    id: id
                },
                success: function () {
                    // Reload the page after deleting faculty
                    location.reload();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }

        // Function to handle edit faculty action
        function editFaculty(id) {
            // Retrieve faculty details using AJAX and populate the form for editing
            $.ajax({
                url: "FacultyServlet?action=get&id=" + id,
                type: "GET",
                success: function (response) {
                    $("#editId").val(response.id);
                    $("#editName").val(response.name);
                    $("#editDesignation").val(response.designation);
                    $("#editDepartment").val(response.department);
                    $("#editEmail").val(response.email);
                    $("#editPhone").val(response.phone);
                    $("#editDateOfJoining").val(response.dateOfJoining);
                    $("#editForm").show();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    </script>
</body>
</html>
