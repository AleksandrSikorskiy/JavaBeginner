package org.example;

import java.io.*;
import java.util.Arrays;

class SortStringFile {

    int verifyRead(String pathFileSource) {
        int errread = 0;
        try {
            File FileSource = new File(pathFileSource);
            FileReader fileR = new FileReader(FileSource);
            BufferedReader bufRead = new BufferedReader(fileR);
            String line;
            int i = 0;
            while ((line = bufRead.readLine()) != null) {
                i = i + 1;
            }
            bufRead.close();
            fileR.close();
            errread = i;
        } catch (IOException ex) {
            System.out.println("class SortStringFile (" + pathFileSource + ") Error File not found !");
            errread = 0;
        }
        return errread;
    }

    boolean verifyWrite(String pathFileDestination) {
        boolean errwrite = true;
        try {
            File FileDestination = new File(pathFileDestination);
            FileWriter bufWrite = new FileWriter(FileDestination);
            bufWrite.write(" ");
            bufWrite.close();
            errwrite = true;
        } catch (IOException ex) {
            System.out.println("class SortStringFile (" + pathFileDestination + ") Cannot create file !");
            errwrite = false;
        }
        return errwrite;
    }

    boolean sortFile(String pathFileSource, String pathFileDestination) {
        boolean errsort = false;
        int dlinastr = verifyRead(pathFileSource);
        if ((verifyWrite(pathFileDestination)) & (dlinastr > 0)) {
            try {
                File FileSource = new File(pathFileSource);
                FileReader fileR = new FileReader(FileSource);
                BufferedReader bufRead = new BufferedReader(fileR);
                File FileDestination = new File(pathFileDestination);
                FileWriter bufWrite = new FileWriter(FileDestination);
                String line;
                String[] sarr = new String[dlinastr];
                int i = 0;
                while ((line = bufRead.readLine()) != null) {
                    sarr[i] = line;
                    i = i + 1;
                }
                bufRead.close();
                fileR.close();

                Arrays.sort(sarr);

                int j = 0;
                while (j < i) {
                    bufWrite.write(sarr[j].trim() + "\r" + "\n");
                    j = j + 1;
                }
                bufWrite.close();
                errsort = true;
            } catch (IOException ex) {
                System.out.println("class SortStringFile SortFile Error !");
                System.out.println("class SortStringFile SortFile Error !!!!");
                errsort = true;
            }
        }
        return errsort;
    }

    public static void main(String[] args) {
        SortStringFile sortStringFile = new SortStringFile();

       if (sortStringFile.sortFile("c:\\Install\\FileSour.txt","c:\\Install\\FileDest.txt")){
                System.out.println("String file sorted.");
            } else {
                System.out.println("String file sort - error.");
            }

    }
}
