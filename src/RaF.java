import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RaF {

    public void input() {
        try(RandomAccessFile raf = new RandomAccessFile("yurrr.txt", "rw")) {
            raf.seek(raf.length());
            raf.write("AAAAA\nBBBBB\nCCCCC".getBytes());
            String temp;
            String go = "";
            raf.seek(0);
            while ((temp = raf.readLine()) != null) {
                go += temp + "\n";
            }
            System.out.println(go);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        RaF rf = new RaF();
        rf.input();
    }
}
