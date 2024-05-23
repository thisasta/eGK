import java.io.IOException;
import java.io.InputStream;

public class SystemInReader {
    public char leseZeichen(){
        try (InputStream inputStream = System.in){
            return ((char)inputStream.read());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return 'a';
    }

    public String leseWort() {
        String word = "";

        try (InputStream inputStream = System.in){
            do {
                word += (char)inputStream.read();
            } while (inputStream.available() != 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    public void ausgabe() {
        System.out.println(leseWort());
    }

    public static void main(String[] args) {
        SystemInReader reader = new SystemInReader();
        System.out.println(reader.leseWort());
    }
}
