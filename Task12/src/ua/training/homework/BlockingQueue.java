package ua.training.homework;
import java.util.LinkedList;
import java.util.List;

/**
 * Максим
 * 19.04.2018
 */
public class BlockingQueue<T> {
    private static final int LIMIT = 50;

    private List<T> documents = new LinkedList<>();

    public synchronized void put(T document) throws InterruptedException {
        while (documents.size() == LIMIT) {
            wait();
        }
        if (documents.size() < 25) {
            notifyAll();
        }
        documents.add(document);
    }

    public synchronized T take() throws InterruptedException {
        while (documents.size() == 0) {
            wait();
        }
        if (documents.size() > 25) {
            notifyAll();
        }
        Thread.sleep(100);
        return documents.remove(0);
    }
}
