import java.util.*;
import java.io.*;

public class Driver 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        FileWriter writer;
        String input_file = "";
        String output_file = "";
        int n = 0; // size of the matrix
        int[][] x;
        try
        {
            System.out.print("Enter the file name: ");
            input_file = input.nextLine();

            System.out.println("Enter the output file name:");
            output_file = input.nextLine();

            // Create the input file
            File the_file = new File(input_file);
            Scanner reader = new Scanner(the_file);

            // Create the output file
            writer = new FileWriter(output_file);

            // Read the size of the matrix
            n = reader.nextInt();

            // Create the matrix
            x = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    x[i][j] = reader.nextInt();
                }
            }

            // Print the size of the matrix
            writer.write(n + "\n");

            // Transitive Closure
            int[][] warshall = warshall(x, n);

            // Print the transitive closure
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    writer.write(warshall[i][j] + " ");
                }
                writer.write("\n");
            }

            // Close the files
            reader.close();
            writer.close();
            
            // closing input stream
            input.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }


    // Method returns transitive closure using Warshall's algorithm
public static int[][] warshall(int[][] x, int n) 
{
    int[][] result = new int[n][n];

    for (int k = 0; k < n; k++) 
    {
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                result[i][j] = x[i][j] | (x[i][k] & x[k][j]);
            }
        }
        for (int i = 0; i < n; i++)
         {
            for (int j = 0; j < n; j++) 
            {
                x[i][j] = result[i][j];
            }
        }
    }
    return x;
}

}
