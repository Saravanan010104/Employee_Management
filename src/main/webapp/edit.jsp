<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.entity.Employee" %>
<%
    Employee emp = (Employee) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<%@ include file="header.html" %>

<h2>Edit Employee Details</h2>

<form action="editEmployee" method="post">
    <label>Employee ID:</label>
    <input type="number" name="employeeId" value="<%= emp.getEmployeeId() %>" readonly><br>

    <label>First Name:</label>
    <input type="text" name="firstName" value="<%= emp.getFirstName() %>" required><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" value="<%= emp.getLastName() %>" required><br>

    <label>House Number:</label>
    <input type="text" name="houseNumber" value="<%= emp.getHouseNumber() %>" required><br>

    <label>Street Name:</label>
    <input type="text" name="streetName" value="<%= emp.getStreetName() %>" required><br>

    <label>Area:</label>
    <input type="text" name="area" value="<%= emp.getArea() %>" required><br>

    <label>City:</label>
    <input type="text" name="city" value="<%= emp.getCity() %>" required><br>

    <label>Pin Code:</label>
    <input type="number" name="pinCode" value="<%= emp.getPinCode() %>" required><br>

    <label>Email Address:</label>
    <input type="email" name="emailAddress" value="<%= emp.getEmailAddress() %>" required><br>

    <label>Phone Number:</label>
    <input type="number" name="phoneNumber" value="<%= emp.getPhoneNumber() %>" required><br>

    <label>Date of Birth:</label>
    <input type="date" name="dateOfBirth" value="<%= emp.getDateOfBirth() %>" required><br>

    <label>Wedding Date:</label>
    <input type="date" name="weddingDate" value="<%= emp.getWeddingDate() %>" required><br>

    <input type="submit" value="Update Employee">
</form>

</body>
</html>
