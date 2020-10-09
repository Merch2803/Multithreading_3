
public class OutputChars {

    private volatile char outputChar = 'A';

    public synchronized void outputA() {
        for (int i = 0; i < 5; i++) {
            try {
                while (outputChar != 'A') {
                    wait();
                }
                System.out.println(outputChar);
                outputChar = 'B';
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void outputB() {
        for (int i = 0; i < 5; i++) {
            try {
                while (outputChar != 'B') {
                    wait();
                }
                System.out.println(outputChar);
                outputChar = 'C';
                notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void outputC() {
        for (int i = 0; i < 5; i++) {
            try {
                while (outputChar != 'C') {
                    wait();
                }
                System.out.println(outputChar);
                outputChar = 'A';
                notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
