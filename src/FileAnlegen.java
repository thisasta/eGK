import java.io.*;
import java.util.Scanner;

public class FileAnlegen {
    File datei;
    File ordner;


    public void ordnerAnlegen() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Orndernamen eingeben: ");
        ordner = new File(scn.nextLine());
        if (ordner.exists()){
            System.out.println("Ordner existiert bereits!");
        } else if (ordner.mkdir()){
            System.out.println("Hier: " + ordner.getName());
        } else {
            System.out.println("Ordner hat nicht geladen");
        }
    }

    public void dateiAnlegen() {
        try{
            Scanner scn = new Scanner(System.in);
            System.out.println("Dateinamen eingeben: ");
            datei = new File(ordner.getAbsoluteFile()  + "\\" + scn.nextLine());
            if (datei.exists()){
                System.out.println("Datei existiert bereits!");
            } else if (datei.createNewFile()){
                System.out.println("Hier: " + datei.getName());
            } else {
                System.out.println("DAtei hat nicht geladen");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void ausgabe() {
        String[] temp = ordner.list();
        for (String s : temp){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        FileAnlegen fr = new FileAnlegen();
        fr.ordnerAnlegen();
        fr.dateiAnlegen();
        fr.ausgabe();
    }
}
