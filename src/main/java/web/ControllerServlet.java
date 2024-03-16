package web;

import data.ClientDaoJDBC;
import domain.Client;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editClient(request, response);
                    break;
                case "delete":
                    this.deleteClient(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private double calculateTotalBalance(List<Client> clients) {
        double total = 0;
        for (Client client : clients) {
            total += client.getBalance();
        }
        return total;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        if (action != null) {
            switch (action) {
                case "insert":
                    this.insertClient(request, response);
                    break;
                case "modify":
                    this.modifyClient(request,response);
                    break;
                default:
                    this.defaultAction(request, response);
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !balanceString.equals("")) {
            balance = Double.parseDouble(balanceString);
        }

        Client client = new Client(name, lastName, email, phoneNumber, balance);
        int modifiedRegisters = new ClientDaoJDBC().insert(client);
        System.out.println(modifiedRegisters);

        this.defaultAction(request, response);
    }

    private void defaultAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = new ClientDaoJDBC().list();
        System.out.println("Clientes: " + clients);
        HttpSession session = request.getSession();
        session.setAttribute("clients", clients);
        session.setAttribute("totalBalance", this.calculateTotalBalance(clients));
        session.setAttribute("totalClients", clients.size());

        //request.getRequestDispatcher("clients.jsp").forward(request, response);
        response.sendRedirect("clients.jsp");
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        System.out.println("Id client: " + idClient);
        Client client = new ClientDaoJDBC().find(new Client(idClient));
        request.setAttribute("client", client);
        String jspEdit = "/WEB-INF/pages/client/editClient.jsp";
        request.getRequestDispatcher(jspEdit).forward(request, response);
    }
    
    private void modifyClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !balanceString.equals("")) {
            balance = Double.parseDouble(balanceString);
        }

        Client client = new Client(idClient,name, lastName, email, phoneNumber, balance);
        int modifiedRegisters = new ClientDaoJDBC().update(client);
        System.out.println(modifiedRegisters);

        this.defaultAction(request, response);
    }
    
    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Client client = new Client(idClient);
        int modifiedRegisters = new ClientDaoJDBC().delete(client);
        System.out.println(modifiedRegisters);

        this.defaultAction(request, response);
    }
}
