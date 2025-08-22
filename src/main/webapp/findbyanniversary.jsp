<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Employee by Anniversary</title>
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

    /* ===== Form Container ===== */
    .container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        width: 100%;
        max-width: 500px;
        margin: 80px auto;
        text-align: center;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        color: #444;
        display: block;
        margin-bottom: 10px;
    }

    input[type="date"] {
        padding: 10px 12px;
        width: 80%;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 14px;
        margin-bottom: 20px;
        transition: all 0.3s ease;
    }

    input[type="date"]:focus {
        border-color: #2193b0;
        outline: none;
        box-shadow: 0 0 5px rgba(33,147,176,0.5);
    }

    input[type="submit"] {
        background: #2193b0;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 8px;
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
            width: 90%;
            padding: 20px;
        }
        input[type="date"] {
            width: 100%;
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

<!-- Form Card -->
<div class="container">
    <h2>Find Employees by Anniversary</h2>
    <form action="findbyanniversary" method="get">
        <label>Enter Wedding Date:</label>
        <input type="date" name="weddingDate" required>
        <br>
        <input type="submit" value="Find Employees">
    </form>
</div>

</body>
</html>
