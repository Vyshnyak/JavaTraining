package ua.training.homework;

/**
 * Максим
 * 19.04.2018
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Document> queue = new BlockingQueue<>();
        MathematicianProducer mathProd = new MathematicianProducer(queue);
        BiologistProducer bioProd = new BiologistProducer(queue);

        new Thread(mathProd).start();
        new Thread(bioProd).start();

    }
}
