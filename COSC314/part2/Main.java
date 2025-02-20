import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

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
        int p; // Number of pairs
        int[] u;
        int[] v;


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


            for(int i = 0; i < m; i++)
            {
                x[i] = reader.nextInt();
            }

            n = reader.nextInt();
            y = new int[n];

            for(int i = 0; i < n; i++)
            {
                y[i] = reader.nextInt();
            }

            p = reader.nextInt();
            u =  new int[p];
            v = new int[p];


            // Reading pairs
            for(int i = 0; i < p; i++)
            {
                u[i] = reader.nextInt();
                v[i] = reader.nextInt();
            }


            if(isOneToOne(v))
            {
                writer.write("one to one\n");
            }
            else
            {
                writer.write("not one to one\n");
            }


            if(isOnto(v,y))
            {
                writer.write("onto\n");
            }
            else
            {
                writer.write("not onto\n");
            }


            if(isOnto(v,y) && isOneToOne(v))
            {
                writer.write("bijective\n");
            }
            else
            {
                writer.write("not bijective\n");
            }

            writer.close();
            reader.close();
            input.close();



        }
        catch(Exception e)
        {

        }
    }


    public static boolean isOneToOne(int[] arr)
    {

        for(int i = 0; i < arr.length-1; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isOnto(int[] arr1, int[] arr2)
    {
        boolean flag = false;
        for(int i = 0; i < arr2.length; i++)
        {
            for(int j = 0; j < arr1.length; j++)
            {
                if(arr2[i] == arr1[j])
                {
                    flag = true;
                    break;
                }
            }

            if(!flag)
            {
                return false;
            }
            flag = false;
        }

        return true;
    }


    // Method created for debugging
    public static void print(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

}
