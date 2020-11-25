package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Homepage
 */
public class App
{
	public static void main( String[] args )
	{
		System.out.println("1");
		String PathFileSource = "c:\\Install\\FileSour.txt";
		String PathFileDestination = "c:\\Install\\FileDest.txt";

		try {
			System.out.println("2");
			File FileSource = new File(PathFileSource);
			FileReader fileR = new FileReader(FileSource);
			BufferedReader bufRead = new BufferedReader(fileR);
			/*            File FileDestination = new File(PathFileDestination); */
			/*          FileWriter bufWrite = new FileWriter(FileDestination); */
			String line;
			System.out.println("3");
			while ((line = bufRead.readLine()) != null) {
				System.out.println(line);
				System.out.println("4");
				/* Arrays sort(sa,String CASE_INSENSITIVE_ORDER); print(Array toStrings(sa));*/
				/* bufWrite.write(line); */
			}
			bufRead.close();
			System.out.println("5");
			/*  bufWrite.close(); */
		} catch (IOException ex) {
			System.out.println("Source File not found " + PathFileSource + " !!!");
			Boolean ErrorRead = false;
			System.out.println("6");
		}
		Boolean ErrorRead = true;
		System.out.println("7");
	}

}