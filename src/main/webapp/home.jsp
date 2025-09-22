<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.demo.entity.Employee" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary: #2c3e50;
            --secondary: #3498db;
            --accent: #e74c3c;
            --success: #2ecc71;
            --warning: #f39c12;
            --light: #ecf0f1;
            --dark: #2c3e50;
            --gray: #95a5a6;
            --text: #333333;
            --card-shadow: 0 10px 20px rgba(0,0,0,0.12), 0 4px 8px rgba(0,0,0,0.06);
            --transition: all 0.3s ease;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            color: var(--text);
            line-height: 1.6;
            min-height: 100vh;
        }

        /* ===== Header/Navbar ===== */
        .navbar {
            background: var(--primary);
            padding: 0.8rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
            position: sticky;
            top: 0;
            z-index: 1000;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        .navbar-brand {
            display: flex;
            align-items: center;
            font-weight: 700;
            font-size: 1.4rem;
        }

        .navbar-brand i {
            margin-right: 0.5rem;
            color: var(--secondary);
        }

        .navbar-nav {
            display: flex;
            align-items: center;
        }

        .nav-link {
            color: white;
            text-decoration: none;
            margin-left: 1.5rem;
            font-weight: 500;
            display: flex;
            align-items: center;
            padding: 0.5rem 0.8rem;
            border-radius: 4px;
            transition: var(--transition);
        }

        .nav-link i {
            margin-right: 0.5rem;
            font-size: 0.9rem;
        }

        .nav-link:hover, .nav-link.active {
            background: rgba(255, 255, 255, 0.1);
            color: var(--secondary);
        }

        .nav-toggle {
            display: none;
            background: none;
            border: none;
            color: white;
            font-size: 1.5rem;
            cursor: pointer;
        }

        /* ===== Main Container ===== */
        .main-container {
            padding: 2rem;
            max-width: 1200px;
            margin: 0 auto;
        }

        /* ===== Card Components ===== */
        .card {
            background: white;
            border-radius: 12px;
            box-shadow: var(--card-shadow);
            overflow: hidden;
            margin-bottom: 2rem;
        }

        .card-header {
            background: var(--primary);
            color: white;
            padding: 1.2rem 1.5rem;
            font-weight: 600;
            font-size: 1.2rem;
            display: flex;
            align-items: center;
        }

        .card-header i {
            margin-right: 0.8rem;
        }

        .card-body {
            padding: 1.5rem;
        }

        /* ===== Forms ===== */
        .form-group {
            margin-bottom: 1.2rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: var(--dark);
        }

        .form-control {
            width: 100%;
            padding: 0.8rem 1rem;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 1rem;
            transition: var(--transition);
        }

        .form-control:focus {
            outline: none;
            border-color: var(--secondary);
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.2);
        }

        .btn {
            display: inline-block;
            padding: 0.8rem 1.5rem;
            background: var(--secondary);
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: 600;
            cursor: pointer;
            transition: var(--transition);
            text-align: center;
        }

        .btn-block {
            display: block;
            width: 100%;
        }

        .btn:hover {
            background: #2980b9;
            transform: translateY(-2px);
        }

        .btn-primary {
            background: var(--secondary);
        }

        .btn-success {
            background: var(--success);
        }

        .btn-danger {
            background: var(--accent);
        }

        /* ===== Tables ===== */
        .table-responsive {
            overflow-x: auto;
            width: 100%;
        }

        .data-table {
            width: 100%;
            border-collapse: collapse;
        }

        .data-table th {
            background: var(--primary);
            color: white;
            padding: 1rem;
            text-align: left;
            font-weight: 600;
        }

        .data-table td {
            padding: 1rem;
            border-bottom: 1px solid #eee;
        }

        .data-table tr:nth-child(even) {
            background: #f9f9f9;
        }

        .data-table tr:hover {
            background: #f1f1f1;
        }

        .action-cell {
            white-space: nowrap;
        }

        .action-btn {
            display: inline-flex;
            align-items: center;
            padding: 0.4rem 0.8rem;
            border-radius: 4px;
            font-size: 0.9rem;
            margin-right: 0.5rem;
            text-decoration: none;
        }

        .action-btn i {
            margin-right: 0.3rem;
        }

        .btn-edit {
            background: var(--success);
            color: white;
        }

        .btn-delete {
            background: var(--accent);
            color: white;
        }

        /* ===== Grid System ===== */
        .row {
            display: flex;
            flex-wrap: wrap;
            margin: 0 -0.75rem;
        }

        .col {
            flex: 1;
            padding: 0 0.75rem;
        }

        .col-6 {
            flex: 0 0 50%;
            max-width: 50%;
            padding: 0 0.75rem;
        }

        /* ===== Responsive Design ===== */
        @media (max-width: 992px) {
            .navbar-nav {
                position: fixed;
                top: 60px;
                left: -100%;
                background: var(--primary);
                width: 80%;
                height: calc(100vh - 60px);
                flex-direction: column;
                align-items: flex-start;
                padding: 2rem;
                transition: var(--transition);
                box-shadow: 4px 0 10px rgba(0,0,0,0.1);
            }
            
            .navbar-nav.active {
                left: 0;
            }
            
            .nav-link {
                margin: 0.5rem 0;
                width: 100%;
            }
            
            .nav-toggle {
                display: block;
            }
            
            .col-6 {
                flex: 0 0 100%;
                max-width: 100%;
            }
            
            .data-table {
                display: block;
                width: 100%;
                overflow-x: auto;
            }
        }

        @media (max-width: 768px) {
            .main-container {
                padding: 1rem;
            }
            
            .card-header {
                padding: 1rem;
            }
            
            .card-body {
                padding: 1rem;
            }
            
            .data-table th, 
            .data-table td {
                padding: 0.7rem;
            }
        }

        @media (max-width: 576px) {
            .navbar {
                padding: 0.8rem 1rem;
            }
            
            .navbar-brand {
                font-size: 1.2rem;
            }
            
            .data-table {
                font-size: 0.9rem;
            }
            
            .action-btn {
                padding: 0.3rem 0.5rem;
                font-size: 0.8rem;
            }
            
            .data-table th:nth-child(n+5),
            .data-table td:nth-child(n+5) {
                display: none;
            }
        }

        /* ===== Utilities ===== */
        .text-center {
            text-align: center;
        }
        
        .mb-3 {
            margin-bottom: 1.5rem;
        }
        
        .mt-3 {
            margin-top: 1.5rem;
        }
        
        .alert {
            padding: 1rem;
            border-radius: 6px;
            margin-bottom: 1.5rem;
        }
        
        .alert-success {
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        
        .hidden {
            display: none;
        }
        
        .address-cell {
            max-width: 200px;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="navbar-brand">
            <i class="fas fa-users"></i>
            <span>Employee Management</span>
        </div>
        
        <button class="nav-toggle" id="navToggle">
            <i class="fas fa-bars"></i>
        </button>
        
        <div class="navbar-nav" id="navbarNav">
            <a href="addemployee.jsp" class="nav-link">
                <i class="fas fa-user-plus"></i>Add 
            </a>
            <a href="welcome" class="nav-link active">
                <i class="fas fa-list"></i>View 
            </a>
            <a href="findemployee.jsp" class="nav-link">
                <i class="fas fa-search"></i>Search 
            </a>
            <a href="findbydob.jsp" class="nav-link">
                <i class="fas fa-birthday-cake"></i>By Birthday
            </a>
            <a href="findbyanniversary.jsp" class="nav-link">
                <i class="fas fa-glass-cheers"></i>By Anniversary
            </a>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="main-container">
        <div class="card">
            <div class="card-header">
                <i class="fas fa-list"></i>${title}
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="data-table">
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
                            <td class="address-cell"><%= emp.getHouseNumber()+", "+emp.getStreetName()+", "+emp.getArea()+", "+emp.getCity()+" - "+emp.getPinCode() %></td>
                            <td class="action-cell">
                                <a class="action-btn btn-edit" href="editEmployee?id=<%= emp.getEmployeeId() %>">
                                    <i class="fas fa-edit"></i> Edit
                                </a>
                            </td>
                            <td class="action-cell">
                                <a class="action-btn btn-delete" href="deleteEmployee?id=<%= emp.getEmployeeId() %>">
                                    <i class="fas fa-trash"></i> Delete
                                </a>
                            </td>
                        </tr>
                        <% } %>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Mobile navigation toggle
        document.getElementById('navToggle').addEventListener('click', function() {
            document.getElementById('navbarNav').classList.toggle('active');
        });
        
        // Close mobile nav when clicking outside
        document.addEventListener('click', function(event) {
            const nav = document.getElementById('navbarNav');
            const toggle = document.getElementById('navToggle');
            
            if (!nav.contains(event.target) && !toggle.contains(event.target) && nav.classList.contains('active')) {
                nav.classList.remove('active');
            }
        });
    </script>
</body>
</html>