import java.io.*;
import java.util.*;
/**
 * Beamer: FileOutput bzw FileInputStreams (ohne Zusatzaufgabe)
 */

public class ByteStreams {

    private File f;
    private String text;

    public ByteStreams(){
        this.f = new File("test.txt");

    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        boolean stop = false;
        do{
            System.out.println("\n\n\n\t**************************************************");
            System.out.println("\t                        Men�");
            System.out.println("\t**************************************************");
            System.out.println("\t<1> Text eingeben");
            System.out.println("\t<2> Text auf dem Bildschirm ausgeben");
            System.out.println("\t<3> Text in die Datei \"" + f.getName() + "\" schreiben");
            System.out.println("\t    (Vorhandene Texte werden dadurch gel�scht");
            System.out.println("\t<4> Text in die Datei \"" + f.getName() + "\" am Ende einf�gen");
            System.out.println("\t<5> Inhalt der Datei \"" + f.getName() + "\" auslesen");
            System.out.print("\tEingabe Auswahl: ");
            int auswahl = sc.nextInt();
            System.out.println();

            if (auswahl == 1){
                System.out.print("\tBitte geben Sie einen Text ein: ");
                text = sc1.nextLine();
                System.out.println("\n");
            }
            else if (auswahl == 2){
                System.out.println("\tBildschirmausgabe " + this.text);
                System.out.println("\n");
            }
            else if (auswahl == 3){
                this.schreibeTextInDatei(text);
                System.out.println("\tMeldung: Der Text \"" + text + "\" wurde in die Datei \"" + f.getName() + "\" geschrieben!");
                System.out.println("\n");
            }
            else if (auswahl == 4){
                this.schreibeTextInDatei(text, true);     //false ersetzt den Text der Datei
                System.out.println("\tMeldung: Der Text \"" + text + "\" wurde am Ende in die Datei \"" + f.getName() + "\" eingef�gt!");
                System.out.println("\n");
            }
            else if (auswahl == 5){
                this.dateiAuslesen();
                System.out.println("\tText \"" + this.dateiAuslesen() + "\" in der Datei \"" + f.getName() + "\": ");
                System.out.println("\n");
            }
        }while (!stop);
    }

    public void schreibeTextInDatei(String text){
        //Schreiben mit byte-orientiertem Stream
        try(FileOutputStream fos = new FileOutputStream(f)){
            fos.write(text.getBytes());
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void schreibeTextInDatei(String text, boolean append){
        //Schreiben mit byte-orientiertem Stream
        try(FileOutputStream fos = new FileOutputStream(f, append)){
            fos.write(text.getBytes());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String dateiAuslesen(){
        //Auslesen mit byte-orientiertem Stream
        String temp = "";
        try(FileInputStream fis = new FileInputStream(f)){
            while(fis.available() != 0) {
                temp += (char)fis.read();
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static void main(String[] args) {
        ByteStreams bs = new ByteStreams();
        bs.menu();
        System.out.println();
        System.out.println();
    }
}

