package Chapter19_ParallelComputing;

public class Parallel_05_Deadlock {
    public static class Account {
        private int balance;
        private int id;
        private static int globalId;

        Account(int balance) {
            this.balance = balance;
            this.id = ++globalId;
        }

        private boolean move(Account to, int amount) {
            Account lock1 = id < to.id ? this : to;
            Account lock2 = id < to.id ? to : this;

            synchronized (lock1) {
                synchronized (lock2) {
                    if (amount > balance) return false;
                    to.balance += amount;
                    balance -= amount;
                    System.out.println("returning true");
                    return true;
                }
            }
        }

        public static void transfer(Account from, Account to, int amount) {
            Thread transfer = new Thread(() -> from.move(to, amount));
            transfer.start();
        }
    }

    public static void main(String[] args) {
        // create scenario where deadlock can happen:
        Account account1 = new Account(1000);
        Account account2 = new Account(1893);
        Account.transfer(account1, account2, 200);
        Account.transfer(account2, account1, 100);
    }
}
