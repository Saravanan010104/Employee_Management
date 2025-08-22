<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
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
    }

    .navbar a:hover {
        color: #ffeb3b;
    }

    /* ===== Container for Form ===== */
    .container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        width: 100%;
        max-width: 500px;
        margin: 60px auto; /* spacing below header */
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    label {
        font-weight: bold;
        margin-bottom: 6px;
        color: #444;
    }

    input {
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 8px;
        margin-bottom: 15px;
        font-size: 14px;
        transition: all 0.3s ease;
    }

    input:focus {
        border-color: #2193b0;
        outline: none;
        box-shadow: 0 0 5px rgba(33,147,176,0.5);
    }

    input[type="submit"] {
        background: #2193b0;
        color: #fff;
        border: none;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #176d80;
    }

    /* Responsive */
    @media (max-width: 600px) {
        .navbar {
            flex-direction: column;
            align-items: flex-start;
        }
        .navbar h1 {
            margin-bottom: 10px;
        }
        .container {
            padding: 20px;
            width: 90%;
        }
    }
</style>
</head>
<body>

<!-- Replace include with styled navbar -->
<div class="navbar">
    <h1>Employee Management</h1>
    <div>
        <a style="color: white;text-decoration: none;font-weight: bold;font-size: 16px; " href="addemployee.jsp">Add Employee</a>
        <a style="color: white;text-decoration: none;font-weight: bold;font-size: 16px; " href="welcome">View Employees</a>
        <a style="color: white;text-decoration: none;font-weight: bold;font-size: 16px; " href="findemployee.jsp">Search Employee</a>
        <a style="color: white;text-decoration: none;font-weight: bold;font-size: 16px; " href="findbydob.jsp">Search By Birthday</a>
        <a style="color: white;text-decoration: none;font-weight: bold;font-size: 16px; " href="findbyanniversary.jsp">Search By Anniversary</a>    
  
    </div>
</div>

<div class="container">
    <h2>Add Employee</h2>
    <form action="addEmployeeServlet" method="post">
        <label>Employee Id</label>    
        <input type="number" name="employeeId" required>
        
        <label>First Name</label>
        <input type="text" name="firstName" required>
        
        <label>Last Name</label>
        <input type="text" name="lastName" required>
        
        <label>House Number</label>
        <input type="text" name="houseNumber" required>
        
        <label>Street Name</label>
        <input type="text" name="streetName" required>
        
        <label>Area</label>
        <input type="text" name="area" required>
        
        <label>City</label>
        <input type="text" name="city" required>
        
        <label>Pincode</label>
        <input type="number" name="pinCode" required>
        
        <label>Email Address</label>
        <input type="email" name="emailAddress" required>
        
        <label>Phone Number</label>
        <input type="number" name="phoneNumber" required>
        
        <label>Date of Birth</label>
        <input type="date" name="dateOfBirth" required>
        
        <label>Wedding Date</label>
        <input type="date" name="weddingDate" required>
        
        <input type="submit" value="Add Employee">
    </form>
</div>

</body>
</html>
