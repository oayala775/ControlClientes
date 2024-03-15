package data;

import domain.Client;
import java.util.*;
import java.sql.*;

public class ClientDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM client";
    private static final String SQL_SELECT_BY_ID = "SELECT idclient, name, last_name, email, phone, balance FROM client WHERE idclient=?";
    private static final String SQL_INSERT = "INSERT INTO client(name,last_name,email,phone,balance) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE client SET name=?, last_name=?, email=?, phone=?, balance=? WHERE idclient=?";
    private static final String SQL_DELETE = "DELETE FROM client WHERE idclient=?";

    public List<Client> list() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idClient = rs.getInt("idclient");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                client = new Client(idClient, name, lastName, email, phone, balance);

                clients.add(client);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }

        return clients;
    }

    public Client find(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getIdClient());
            rs = stmt.executeQuery();
            rs.absolute(1);
            String name = rs.getString("name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("balance");
            client.setName(name);
            client.setLastName(lastName);
            client.setEmail(email);
            client.setPhoneNumber(phone);
            client.setBalance(balance);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }

        return client;
    }

    public int insert(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhoneNumber());
            stmt.setDouble(5, client.getBalance());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }

        return rows;
    }

    public int update(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhoneNumber());
            stmt.setDouble(5, client.getBalance());
            stmt.setInt(6, client.getIdClient());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }

        return rows;
    }

    public int delete(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getIdClient());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }

        return rows;
    }
}
