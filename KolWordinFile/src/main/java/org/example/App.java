package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class App {

    public static void main(String[] args) throws FileNotFoundException{
        getWordCount("C:\\Install\\word.txt");
    }

    public static void getWordCount(String filename) throws FileNotFoundException{
        String[] maxarr=new String[5000];
        int j=0;
        for (j=0;j<5000;j++){
            maxarr[j]="";
        }
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int imax = 0;
            String linestr = "";
            while (scanner.hasNextLine()) {
                String[] minarr = scanner.nextLine().split(" ");
                for (int i = 0; i < minarr.length; i++) {
                    linestr = minarr[i].trim();
                    if (!"".equals(linestr))  /**(linestr != "")**/ {
                        maxarr[imax] = linestr;
                        imax++;
                    }
                }
            }
            File fileDestination = new File("c:\\Install\\grpword.txt");
            FileWriter bufWrite = null;
            bufWrite = new FileWriter(fileDestination);
            Arrays.sort(maxarr);

            int k = 0;
            int kol = 1;
            for (k = 0; k < 4999; k=k+1) {
                if (maxarr[k].equals(maxarr[k + 1])) {
                    kol = kol + 1;
                } else {
                    bufWrite.write(maxarr[k] +" "+ kol + "\r" + "\n");
                    kol = 1;
                }
             }
            bufWrite.write(maxarr[k] +" "+ kol + "\r" + "\n");

            scanner.close();
            bufWrite.close();
        } catch (IOException e){
            e.printStackTrace();
        }
       System.out.println(Arrays.toString(maxarr));

    }
}
      /**  открываем  файл **/
      /**          читаем строку **/
        /** обнуляем мини **/
       /**                 собираем в мини **/
        /**        добавляем в макси **/
        /** следующее чтение **/
        /**        выводим на экран **/
