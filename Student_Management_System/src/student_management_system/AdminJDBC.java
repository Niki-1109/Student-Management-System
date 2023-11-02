package student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminJDBC {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	
	public void login(Admin admin) {
		StudentMain main = new StudentMain();
		try {
			connection = openConnection();
			query = "SELECT * FROM credentials WHERE email = ? && password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getEmail());
			preparedStatement.setString(2, admin.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Login Successful!");
				main.stud();
			}
			else {
				System.out.println("Invalid credentials!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void signin(Admin admin) {
		try {
			connection = openConnection();
			query = "INSERT INTO credentials VALUES(?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getEmail());
			preparedStatement.setString(2, admin.getPassword());
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " row(s) affected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "Nikita@123" );
	}
		
	private void closeConnection() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
}
