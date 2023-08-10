package com.dvops.maven.eclipse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sddevops.cwf_maven.eclipse.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/app_userdetails";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "password";

    private static final String SELECT_USER_BY_ID = "SELECT name, password, email, language FROM user_details WHERE name = ?";
    private static final String UPDATE_USER_SQL = "UPDATE user_details SET name = ?, password = ?, email = ?, language = ? WHERE name = ?";
    private static final String SELECT_CATALOG_ITEMS = "SELECT item_name FROM catalog";
    private static final String INSERT_ADDRESS_SQL = "INSERT INTO user_addresses (name, address) VALUES (?, ?)";
    private static final String INSERT_CART_ITEM_SQL = "INSERT INTO shopping_cart (name, item) VALUES (?, ?)";
    private static final String DELETE_CART_ITEM_SQL = "DELETE FROM shopping_cart WHERE name = ? AND item = ?";
    private static final String CLEAR_CART_SQL = "DELETE FROM shopping_cart WHERE name = ?";
    private static final String GET_CART_ITEMS_SQL = "SELECT item FROM shopping_cart WHERE name = ?";
    private static final String INSERT_PAYMENT_SQL = "INSERT INTO payments (name, payment_type) VALUES (?, ?)";
    private static final String SELECT_PAYMENT_SQL = "SELECT payment_type FROM payments WHERE name = ?";
    private static final String DELETE_PAYMENT_SQL = "DELETE FROM payments WHERE name = ?";
   
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
   
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        User existingUser = new User("", "", "", "");
       
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String language = rs.getString("language");
                existingUser = new User(name, password, email, language);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
    }
   
    private void updatePass(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String oriName = request.getParameter("oriName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String language = request.getParameter("language");
       
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, language);
            statement.setString(5, oriName);
            int i = statement.executeUpdate();
        }
       
        response.sendRedirect("http://localhost:8090/CourseworkFinal/UserServlet/dashboard");
    }
   
    private void browseCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATALOG_ITEMS)) {
            ResultSet rs = preparedStatement.executeQuery();
            List<String> catalogItems = new ArrayList<>();
            while (rs.next()) {
                String itemName = rs.getString("item_name");
                catalogItems.add(itemName);
            }
           
            request.setAttribute("catalogItems", catalogItems);
            request.getRequestDispatcher("/catalog.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    private void addAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
       
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_ADDRESS_SQL)) {
            statement.setString(1, name);
            statement.setString(2, address);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("<h1>Address added successfully!</h1>");
            } else {
                response.getWriter().println("<h1>Failed to add address.</h1>");
            }
        }
    }
   
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("http://localhost:8090/CourseworkFinal/login.jsp");
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        String name = request.getParameter("name");
        String password = request.getParameter("password");
       
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT name, password FROM user_details WHERE name = ? AND password = ?")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                out.println("<h1>You have successfully logged in!</h1>");
                response.sendRedirect("http://localhost:8090/CourseworkFinal/welcome.jsp");
            } else {
                out.println("<h1>Authentication failed. Invalid username or password.</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>An error occurred while processing your request.</h1>");
        }
    }
}
