import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderReader {
    public String leseWort() {
        String word = "";
        InputStream ind = System.in;
        try (InputStreamReader inputStreamReader = new InputStreamReader(ind)){
            do {
                word += (char)inputStreamReader.read();
            } while (inputStreamReader.ready());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    public static void main(String[] args) {
        InputStreamReaderReader reader = new InputStreamReaderReader();
        System.out.println(reader.leseWort());
    }
}
