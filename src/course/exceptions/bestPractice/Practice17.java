package course.exceptions.bestPractice;

/**
 * Best practice 17
 * Передайте всю релевантную информацию исключениям,
 * чтобы сделать их максимально информативными.
 *
 */
public class Practice17 {
    public static void main(String[] args) {
        Client client = new Client("Пётр Петров", 1000);

        try {
            client.withdraw(2000);
        } catch (OutOfCashException e) {
            System.out.println(e.getMessage());
            System.out.println("Баланс: " + e.getBalance());
        }
    }
}


class OutOfCashException extends Exception {

    private double balance;

    public OutOfCashException(String message, double balance) {
        super(message);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}


class Client {
    private String name;
    private double balance;

    public Client(String name, double money) {
        this.name = name;
        this.balance = money;
    }

    public void withdraw(double value) throws OutOfCashException {
        balance -= value;

        if(balance < 0) {
            throw new OutOfCashException("Баланс клиента " + name + " стал отрицательным!", balance);
        }
    }
}
