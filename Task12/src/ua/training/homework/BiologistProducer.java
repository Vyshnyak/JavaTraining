package ua.training.homework;

/**
 * Максим
 * 19.04.2018
 */
public class BiologistProducer implements Runnable {
    private BlockingQueue<Document> queue;

    public BiologistProducer(BlockingQueue<Document> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                queue.put(new Biologist());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
