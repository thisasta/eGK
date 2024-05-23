import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderReader {
    public String leseZeile(){
        String temp = "";
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            temp = in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public String leseMehrereZeilen() {
        String word = "";
        String temp;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            while ((temp = in.readLine()) != null && !temp.contains("over")){
                word += temp;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    public void ausgabe() {
        System.out.println(leseMehrereZeilen());
    }

    public static void main(String[] args) {
        BufferedReaderReader reader = new BufferedReaderReader();
        reader.ausgabe();
    }
}
