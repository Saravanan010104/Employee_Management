<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.demo.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #6dd5ed, #2193b0);
            margin: 0;
            padding: 0;
        }

        /* ===== Header/Navbar ===== */
        .navbar {
            background: #176d80;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: #fff;
            position: sticky;
            top: 0;
            z-index: 1000;
            box-shadow: 0 3px 10px rgba(0,0,0,0.2);
        }

        .navbar h1 {
            margin: 0;
            font-size: 20px;
            letter-spacing: 1px;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
            font-weight: bold;
            transition: 0.3s;
            font-size: 16px;
        }

        .navbar a:hover {
            color: #ffeb3b;
        }

        /* ===== Page Content ===== */
        .container {
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
            width: 95%;
            max-width: 1100px;
            margin: 60px auto;
            overflow-x: auto;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
            margin-top: 20px;
        }

        th {
            background: #2193b0;
            color: white;
            padding: 12px;
            text-transform: uppercase;
        }

        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        tr:hover {
            background: #f1f1f1;
        }

        a.action-link {
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 6px;
            font-size: 13px;
            font-weight: bold;
            transition: 0.3s;
        }

        a.edit {
            background: green;
            color: white;
        }
        a.edit:hover {
            background: #388E3C;
        }

        a.delete {
            background: grey;
            color: white;
        }
        a.delete:hover {
            background: #d32f2f;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .container {
                padding: 20px;
                width: 95%;
            }

            table {
                font-size: 12px;
            }

            .navbar {
                flex-direction: column;
                align-items: flex-start;
            }

            .navbar h1 {
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>

<!-- Navbar -->
<div class="navbar">
    <h1>Employee Management</h1>
    <div>
        <a href="addemployee.jsp">Add Employee</a>
        <a href="welcome">View Employees</a>
        <a href="findemployee.jsp">Search Employee</a>
        <a href="findbydob.jsp">Search By Birthday</a>
        <a href="findbyanniversary.jsp">Search By Anniversary</a>    
    </div>
</div>

<!-- Table Container -->
<div class="container">
    <h2>${title}</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>D.O.B</th>
            <th>Wedding Date</th>
            <th>Address</th>
            <th colspan="2">Actions</th>
        </tr>
        <%
            List<Employee> list = (List<Employee>) request.getAttribute("list");
            for(Employee emp : list) {
        %>
        <tr>
            <td><%= emp.getEmployeeId() %></td>
            <td><%= emp.getFirstName() + " " + emp.getLastName() %></td>
            <td><%= emp.getEmailAddress() %></td>
            <td><%= emp.getPhoneNumber() %></td>
            <td><%= emp.getDateOfBirth() %></td>
            <td><%= emp.getWeddingDate() %></td>
            <td><%= emp.getHouseNumber()+", "+emp.getStreetName()+",<br>"+emp.getArea()+",<br>"+emp.getCity()+",<br>"+emp.getPinCode() %></td>
            <td><a class="action-link edit" href="editEmployee?id=<%= emp.getEmployeeId() %>">Edit</a></td>
            <td><a class="action-link delete" href="deleteEmployee?id=<%= emp.getEmployeeId() %>">Delete</a></td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>
