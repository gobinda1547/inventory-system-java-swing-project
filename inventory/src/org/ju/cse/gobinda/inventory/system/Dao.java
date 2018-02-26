package org.ju.cse.gobinda.inventory.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {

	public static Connection getDatabaseConnection() {

		try {
			String dbUrl = "jdbc:h2:./dbfile";
			String dbUserName = "";
			String dbPassword = "";
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean createItemTable() {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("CREATE TABLE IF NOT EXISTS item(");
			sql.append("itemname CHAR, ");
			sql.append("itemamount CHAR, ");
			sql.append("itemunit CHAR, ");
			sql.append("PRIMARY KEY(itemname))");

			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean deleteThisItem(String itemName) {
		try {
			Connection conn = getDatabaseConnection();
			String sql = "DELETE FROM item WHERE itemname = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.execute();

			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean insertItem(Item item) {

		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement insertPreparedStatement = null;
			String InsertQuery = "INSERT INTO item (itemname, itemamount, itemunit) values (?,?,?)";

			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, item.getItemName());
			insertPreparedStatement.setString(2, item.getItemAmount());
			insertPreparedStatement.setString(3, item.getItemUnit());

			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ArrayList<Item> getAllItems() {

		ArrayList<Item> items = new ArrayList<>();

		try {
			String sql = null;
			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM item;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				items.add(new Item(rs.getString(1), rs.getString(2), rs.getString(3)));
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	public static Item getItemAccordingToName(String itemName) {
		try {
			Connection conn = getDatabaseConnection();

			String sql = "SELECT * FROM item where itemname=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, itemName);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3));
				preparedStatement.close();
				conn.close();
				return item;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updateThisItem(String itemName, String itemAmount) {
		try {
			Connection conn = getDatabaseConnection();
			String sql = "UPDATE item SET itemamount=? WHERE itemname=?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, itemAmount);
			preparedStatement.setString(2, itemName);

			preparedStatement.execute();

			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean createCustomerTable() {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("CREATE TABLE IF NOT EXISTS customer(");
			sql.append("name CHAR, ");
			sql.append("mobile CHAR, ");
			sql.append("details CHAR, ");
			sql.append("due CHAR, ");
			sql.append("PRIMARY KEY(name))");

			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean deleteThisCustomer(String customerName) {
		try {
			Connection conn = getDatabaseConnection();
			String sql = "DELETE FROM customer WHERE name = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, customerName);
			preparedStatement.execute();

			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean insertCustomer(Customer customer) {

		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement insertPreparedStatement = null;
			String InsertQuery = "INSERT INTO customer (name, mobile, details, due) values (?,?,?,?)";

			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, customer.getCustomerName());
			insertPreparedStatement.setString(2, customer.getCustomerMobileNumber());
			insertPreparedStatement.setString(3, customer.getCustomerDetails());
			insertPreparedStatement.setString(4, customer.getCustomerDueBill());

			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ArrayList<Customer> getAllCustomers() {

		ArrayList<Customer> customers = new ArrayList<>();

		try {
			String sql = null;
			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM customer;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				customers.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static Customer getCustomerAccordingToName(String customerName) {
		try {
			Connection conn = getDatabaseConnection();

			String sql = "SELECT * FROM customer where name=?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, customerName);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				preparedStatement.close();
				conn.close();
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updateCustomerDueBillWhereNameIs(String customerName, String updatedDueBill) {
		try {
			Connection conn = getDatabaseConnection();
			String sql = "UPDATE customer SET due=? WHERE name=?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, updatedDueBill);
			preparedStatement.setString(2, customerName);
			boolean tof = preparedStatement.execute();
			System.out.println("db operation succccessfll or not: " + tof);
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
