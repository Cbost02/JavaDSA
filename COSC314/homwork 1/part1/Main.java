import java.util.*;
import java.io.*;

// Make sure files have original instructor files!!! < - - Delete this code once done.
public class Main
{
    static int current_index_one = 0;
    static int current_index_two = 0;
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
        int[] v; // A n B

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

            current_index_one = x.length;

            u = union(x,y,u);

            int p = current_index_one;

         
            writer.write("" + p + "\n");


            for(int i = 0; i < p; i++)
            {
                writer.write("" + u[i] + " ");
            }
            writer.write("\n\n");



            // Intersection
            v = new int[m+n];

            v = intersection(x, y, v);


            int q = current_index_two;

            writer.write("" + q + "\n");


            for(int i = 0; i < q; i++)
            {
                writer.write("" + v[i] + " ");
            }




            writer.close();
            reader.close();
            

        }
        catch(Exception e)
        {
            System.out.println("There was no file found by that name!");
        }
    }


    public static int[] union(int[] arr1, int[] arr2, int [] union)
    {
        // Copy values from x into u
        for(int i = 0; i < arr1.length; i++)
        {
            union[i] = arr1[i];
        }


        // Copy unknown values from y into u

        boolean not_found = true;

        for(int i = 0; i < arr2.length; i++)
        {
            for(int j = 0; j < arr1.length; j++)
            {
                if(arr1[j] == arr2[i])
                {
                    not_found = false;
                    break;
                }
            }

            if(not_found)
            {
                union[current_index_one] = arr2[i];
                current_index_one++;
            }
            not_found = true;
        }
        return union;
    }


    public static int[] intersection(int[] arr1, int[] arr2, int[] intersection)
    {


        for(int i = 0; i < arr2.length; i++)
        {
            for(int j = 0; j < arr1.length; j++)
            {
                if(arr1[j] == arr2[i])
                {
                    intersection[current_index_two] = arr1[j];
                    current_index_two++;
                    break;
                }
            }
        }

        return intersection;
    }

}