package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        public static void sortFile(String file, boolean bNumeric, String additionalArgs) throws DiskSortIOException {
        File infile = new File(file);
        File sortedfile = new File(file + ".sorted.tmp");
        sortFile(infile,sortedfile,bNumeric,additionalArgs);
        infile.delete();
        sortedfile.renameTo(infile);
    }
        System.out.println( "Hello World!" );
    }
}
