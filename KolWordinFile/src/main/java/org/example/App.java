package org.example;

import java.io.*;
import java.util.Arrays;


class App {

    class MiniArr {
        String[] miniarrs = new String[100];
        int[] miniarri = new int[100];
    }

    class MaxiArr {
        String[] miniarrs = new String[500];
        int[] miniarri = new int[500];
    }

    MiniArr marr=new MiniArr();

    MiniArr strokatowordarr(String linein) {
     MiniArr mini = new MiniArr();
     int j=0;
     while (j<100) {

      j=j+1;
     }
     return  mini;
    }


    public static void main(String[] args) {
        MaxiArr maxiArr = new MaxiArr();
        MiniArr miniArr = new MiniArr();
        int imax=0;
        int imin = 0;

        try {
            File FileSource = new File("c:\\Install\\word.txt");
            FileReader fileR = new FileReader(FileSource);
            BufferedReader bufRead = new BufferedReader(fileR);
            String line;
            int i = 0;
            while ((line = bufRead.readLine()) != null) {
                miniArr=strokatowordarr(line);
                i = i + 1;
            }
            bufRead.close();
            fileR.close();
        } catch (IOException ex) {
            System.out.println("class KolWordInFile (" + pathFileSource + ") Error File not found !");
        }
      /**  открываем  файл **/
      /**          читаем строку **/
        /** обнуляем мини **/
       /**                 собираем в мини **/
        /**        добавляем в макси **/
        /** следующее чтение **/
        /**        выводим на экран **/



    }
}
}
