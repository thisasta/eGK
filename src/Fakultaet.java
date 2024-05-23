import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Fakultaet {
    public void FakultaetIterativ() {
        int temp = 1;
        try(RandomAccessFile raf = new RandomAccessFile("ite.txt", "rw")) {
            for (int i = 1; i < 21; i++) {
                temp = temp * i;
                raf.write(("Fakultaet von " + i + "!: " + temp).getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        Fakultaet fa = new Fakultaet();
        fa.FakultaetIterativ();
    }
}
