package domain;

public class Client {
    private int idClient;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String name, String lastName, String email, String phoneNumber, double balance) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Client(String name, String lastName, String email, String phoneNumber, double balance) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client #").append(this.idClient);
        sb.append("Name: ").append(this.name).append(" ").append(this.lastName);
        sb.append("Email: ").append(this.email);
        sb.append("Phone Number: ").append(this.phoneNumber);
        sb.append("Balance: ").append(this.balance);
        return sb.toString();
    }
    
    
}
