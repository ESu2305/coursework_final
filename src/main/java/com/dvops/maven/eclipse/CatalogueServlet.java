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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sddevops.cwf_maven.eclipse.Catalogue;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String jdbcURL = "jdbc:mysql://localhost:3306/catalogue";
    String dbUsername = "root";
    String dbPassword = "password";

    private static final String SELECT_ALL_ITEMS = "SELECT * FROM Catalogue";

    /**
     * @see HttpServlet#HttpServlet()
     */
    

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void listCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Catalogue> cat = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String item = rs.getString("item");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                cat.add(new Catalogue(item, name, price, quantity, image));
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        request.setAttribute("listCat", cat);
        request.getRequestDispatcher("/catalogue.jsp").forward(request, response);
    }
    
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//response.getWriter().append("Served at: ").append(request.getContextPath());
    	String action = request.getServletPath();

		try {
			switch (action) {
			case "/CatalogueServlet/items":
				listCat(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
}
