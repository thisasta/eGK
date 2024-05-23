import java.io.IOException;
import java.io.RandomAccessFile;

public class RaFExtended {
    public void listeNamen(){
        try(RandomAccessFile raf = new RandomAccessFile("Adressen.txt", "r")){
            String temp;
            while((temp = raf.readLine()) != null){
                String[] content = temp.split(",");
                System.out.println(content[0] + " " + content[1]);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        RaFExtended raf = new RaFExtended();
        raf.listeNamen();
    }
}
