package org.example;

/**
 * Hello world!
 */
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Gseawar seawar = new Gseawar(7);
        seawar.newgame();
        seawar.printallmap();
        while (seawar.pobeda) {
            Scanner ids = new Scanner(System.in);
            System.out.print("Куда стреляем: ");
            String id = ids.nextLine();
            seawar.fireonmapmy(id.toUpperCase());
            seawar.fireonmapvs();
            seawar.printallmap();
            seawar.checkpobeda();
        }
    }
}
