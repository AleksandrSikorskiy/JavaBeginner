package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


class LengthComparator implements Comparator<String> {
    public int compare(String arg0, String arg1) {
        // Use Integer.compare to compare the two Strings' lengths.
        return Integer.compare(arg0.length(), arg1.length());
    }
}

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main(String[] args )
    {
        System.out.println("1");
        String PathFileSource = "c:\\Install\\FileSour.txt";
        String PathFileDestination = "c:\\Install\\FileDest.txt";

        try {
            System.out.println("2");
            File FileSource = new File(PathFileSource);
            FileReader fileR = new FileReader(FileSource);
            FileReader fileR1 = new FileReader(FileSource);
            BufferedReader bufRead = new BufferedReader(fileR);
            BufferedReader bufRead1 = new BufferedReader(fileR1);
            File FileDestination = new File(PathFileDestination);
            FileWriter bufWrite = new FileWriter(FileDestination);
            String line;

            System.out.println("3");
            int i = 0;
            while ((line = bufRead.readLine()) != null) {
                i = i + 1;
            }
            bufRead.close();
            fileR.close();

            System.out.println("4");
            String[] sarr = new String[i];
            i = 0;
            while ((line = bufRead1.readLine()) != null) {
                sarr[i]=line;
                i = i + 1;
            }
            bufRead1.close();
            fileR1.close();
            System.out.println("5");

            Arrays.sort(sarr);
            int j=0;
            while (j<i) {
                bufWrite.write(sarr[j]+"\t"+"\n");
                j=j+1;
            }
            bufWrite.close();
            System.out.println("6");
            /*  bufWrite.close(); */
        } catch (IOException ex) {
            System.out.println("Source File not found " + PathFileSource + " !!!");
            Boolean ErrorRead = false;
            System.out.println("7");
        }
        Boolean ErrorRead = true;
        System.out.println("8");

    }
}
