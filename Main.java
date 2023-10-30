import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Main {
      static Scanner in=new Scanner(System.in);
    public static void main (String[] args) {
        String input = "ABCEEFR";
        int windowSize = 12;

    ArrayList<lz77.Tag> compressed = lz77.compress(input, windowSize);
        
    String decompressed = lz77.decompress(compressed); 

    System.out.println("press 1 for file based and press 2 for console based: ");
    int choice= in.nextInt(); 

    if(choice==1)
    {      
       try{  
        
        BufferedWriter f_writer=new BufferedWriter(new FileWriter("compressedfile.txt"));
        f_writer.write(compressed.toString());
        
        System.out.println("compressed file created successfuly ");
        f_writer.close();

        f_writer=new BufferedWriter(new FileWriter("decompresedfile.txt"));
        f_writer.write( decompressed );
        System.out.println("dcompressed file created successfuly");
        f_writer.close();

        } 
        catch(IOException e)
        { 
            System.out.print(e.getMessage());

        }
    }
       else if (choice==2 )
     {
        System.out.println("Original: " + input);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
    }
    else
      System.out.println("invalid input");
 }
}