package observer;

import java.util.Observable;
import java.util.Observer;

public class Test {

    public static void main(String[] args) {
        Sender sender = new Sender();
        sender.addObserver(new Receiver("A"));
        sender.addObserver(new Receiver("B"));
        sender.addObserver(new Receiver("C"));
        sender.addObserver(new Receiver("D"));

        sender.post("new message!!!");
    }

    private static class Sender extends Observable {

        public void post(String msg) {
            setChanged();

            notifyObservers(msg);
        }
    }

    private static class Receiver implements Observer {

        private String name;

        public Receiver(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable o, Object arg) {
            System.out.println(name + " Get it from " + o.getClass().getSimpleName()
                    + "\t\tmsg = " + arg);
        }
    }
}
