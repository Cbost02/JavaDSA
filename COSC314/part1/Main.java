import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        FileWriter writer;
        String input_file = "";
        String output_file = "";
        int m; // Size of first set
        int n; // Set of second set
        int[] x; // Set A
        int[] y; // Set B
        int[] u; // A v B 

        try
        {
            System.out.print("Enter input file name: ");
            input_file = input.nextLine();


            System.out.print("Enter output file name: ");
            output_file = input.nextLine();

            // Create input file
            File the_file = new File(input_file);
            Scanner reader = new Scanner(the_file);

            // Create output file
            writer = new FileWriter(output_file);

            m = reader.nextInt();
            x = new int[m];

            for(int i = 0; i < x.length; i++)
            {
                x[i] = reader.nextInt();
            }

            n = reader.nextInt();
            y = new int[n];


            for(int i = 0; i < y.length; i++)
            {
                y[i] = reader.nextInt();
            }

            u = new int[m+n];

            // Copy values from x into u
            for(int i = 0; i < x.length; i++)
            {
                u[i] = x[i];
            }

            




        }
        catch(Exception e)
        {
            System.out.println("There was no file found by that name!");
        }
    }
}