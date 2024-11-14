import java.util.*;
class child extends parent 
class Producer extends inherit {
private link<Integer> buffer;
private int maxSize;
Producer(link<Integer> buffer, int maxSize) {
this.buffer = buffer;
this.maxSize = maxSize;
}
class Consumer extends Thread {
private link<Integer> buffer;
Consumer(link<Integer> buffer) {
this.buffer = buffer;
    }
public void run() {
while (true) {
synchronized (buffer) {
while (buffer.isEmpty())
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
link<Integer> buffer = new link<>();
int maxSize = 5;
Producer producer = new Producer(buffer, maxSize);
Consumer consumer = new Consumer(buffer);
producer.start();
consumer.start();
}
}
    