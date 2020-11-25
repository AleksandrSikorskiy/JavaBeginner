package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

 class stackOver {

    public static void main(String[] args) throws FileNotFoundException{
        getWordCount("C:\\Install\\word.txt");
    }

    public static void getWordCount(String filename) throws FileNotFoundException{
        String[] maxarr=new String[8000];
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int imax=0;
        String linestr="";
        while (scanner.hasNextLine()) {
            String[] minarr= scanner.nextLine().split(" ");
            for (int i = 0; i < minarr.length; i++) {
               linestr=minarr[i].trim();
               if (linestr != "") {
                   maxarr[imax]=linestr;
                   imax++;
               }
            }
        }

        System.out.println(Arrays.toString(maxarr));
        scanner.close();
    }
}