class MultiplicationTable extends Thread {
    public void run() {
        System.out.println("Multiplication Table of 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 * " + i + " = " + (5 * i));
        }
    }
}

class PrimeNumbers extends Thread {
    int n;

    PrimeNumbers(int n) {
        this.n = n;
    }

    boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public void run() {
        System.out.println("First " + n + " prime numbers:");
        int count = 0;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count == n)
                    break;
            }
        }
    }
}

public class thread {
    public static void main(String[] args) {
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        PrimeNumbers primeNumbers = new PrimeNumbers(10); // Display first 10 prime numbers
        multiplicationTable.start();
        primeNumbers.start();
    }
}
