package lab2;

interface BankAccountInterface {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getAccountInfo();
}

class BankAccount implements BankAccountInterface {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount + " Текущий баланс: " + balance);
        } else {
            System.out.println("Сумма должна быть положительной");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снято: " + amount + " Текущий баланс: " + balance);
            return true;
        } else {
            System.out.println("Недостаточно средств или некорректная сумма");
            return false;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountInfo() {
        return "Счет: " + accountNumber + ", Владелец: " + ownerName + ", Баланс: " + balance;
    }
}

class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", "Иван Петров");

        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(600);
        System.out.println(account.getAccountInfo());
    }
}