package web;

import data.ClientDaoJDBC;
import domain.Client;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Client> clients = new ClientDaoJDBC().list();
        System.out.println("Clientes: " + clients);
        request.setAttribute("clients", clients);
        request.setAttribute("totalBalance", this.calculateTotalBalance(clients));
        request.setAttribute("totalClients", clients.size());
        
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }
    
    private double calculateTotalBalance(List<Client> clients){
        double total = 0;
        for(Client client: clients){
            total += client.getBalance();
        }
        return total;
    }
}
