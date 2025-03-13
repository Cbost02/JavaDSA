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
        int n = 0; // size of matrix
        int[][] x; // matrux


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

            // Read the values from the file int x
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    x[i][j] = reader.nextInt();
                }
            }

            // Checks if matrix is reflexive
            if (isReflexive(x, n))
            {
                writer.write("reflexive          - yes\n");
            }
            else
            {
                writer.write("reflexive          - no\n");
            }

            // Checks if matrix is symmetric
            if (isSymmetric(x, n))
            {
                writer.write("symmetric          - yes\n");
            }
            else
            {
                writer.write("symmetric          - no\n");
            }

            // Checks if matrix is transitive
            if (isTransitive(x, n))
            {
                writer.write("transitive         - yes\n");
            }
            else
            {
                writer.write("transitive         - no\n");
            }

            // Checks if matrix is antisymmetric
            if (isAntiSymmetric(x, n))
            {
                writer.write("antisymmetric      - yes\n");
            }  
            else
            {
                writer.write("antisymmetric      - no\n");
            }

            // Checks if matrix is equivalent
            if (isEquivalence(x, n))
            {
                writer.write("equivalent         - yes\n");
            }
            else
            {
                writer.write("equivalent         - no\n");
            }

            // Checks if matrix is partial order
            if (isPartialOrder(x, n))
            {
                writer.write("partial order      - yes\n");
            }
            else
            {
                writer.write("partial order      - no\n");
            }

            // Closing the streams
            writer.close();
            reader.close();
            input.close();



        }
        catch(Exception e)
        {
            System.out.println("File not found!!!");
        }
    }

    // Method for determining if the matrix is reflexive
    public static boolean isReflexive(int[][] x, int n)
    {
        for (int i = 0; i < n; i++)
        {
            if (x[i][i] != 1)
            {
                return false;
            }
        }
        return true;
    }

    // Method for determining if the matrix is symmetric
    public static boolean isSymmetric(int[][] x, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (x[i][j] != x[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    // Method for determining if the matrix is transitive
    public static boolean isTransitive(int[][] x, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (x[i][j] == 1 && x[j][k] == 1 && x[i][k] != 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Method for determining if the matrix is antisymmetric
    public static boolean isAntiSymmetric(int[][] x, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i != j && x[i][j] == 1 && x[j][i] == 1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    // Method for determining if the matrix is equivalence
    public static boolean isEquivalence(int[][] x, int n)
    {
        return isReflexive(x, n) && isSymmetric(x, n) && isTransitive(x, n);
    }


    // Method for determining if the matrix is partial order
    public static boolean isPartialOrder(int[][] x, int n)
    {
        return isReflexive(x, n) && isAntiSymmetric(x, n) && isTransitive(x, n);
    }


}