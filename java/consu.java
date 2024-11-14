import java.util.LinkedList;

class Producer extends Thread {
    private LinkedList<Integer> buffer;
    private int maxSize;

    Producer(LinkedList<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (buffer) {
                while (buffer.size() == maxSize) {
                    try {
                        System.out.println("Buffer is full. Producer is waiting...");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing: " + i);
                buffer.add(i);
                buffer.notifyAll(); // Notify waiting consumers
            }
        }
    }
}

class Consumer extends Thread {
    private LinkedList<Integer> buffer;

    Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        System.out.println("Buffer is empty. Consumer is waiting...");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int val = buffer.removeFirst();
                System.out.println("Consuming: " + val);
                buffer.notifyAll(); // Notify waiting producers
            }
        }
    }
}

public class consu {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int maxSize = 5;
        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
    }
}
