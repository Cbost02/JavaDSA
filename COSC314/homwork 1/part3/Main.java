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
        int m; // Size of matrix
        int[][] x; // Matrix X
        int[][] y; // Matrix Y
        int[][] u; // X + Y
        int[][] v; // X * Y


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

            x = new int[m][m];

            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    x[i][j] = reader.nextInt();
                }
            }

            m = reader.nextInt();

            y = new int[m][m];

            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    y[i][j] = reader.nextInt();
                }
            }

            u = sum(x,y,m);


            // printing u

            writer.write(m + "\n");
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    writer.write(u[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");



            v = product(x,y,m);


            // printing v
            writer.write(m + "\n");
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    writer.write(v[i][j] + " ");
                }
                writer.write("\n");
            }

            writer.close();
            input.close();
            reader.close();






        }
        catch(Exception e)
        {
            System.out.println("There is no file by that name!");
        }
    }


    public static int[][] sum(int[][] a, int[][] b, int m)
    {
        int[][] u = new int[m][m];

        for(int i = 0; i <= m-1; i++)
        {
            for(int j = 0; j <= m-1; j++)
            {
                u[i][j] = a[i][j] + b[i][j];
            }
        }

        return u;
    }

    public static int[][] product(int[][] a, int[][] b, int m)
    {
        int[][] v = new int[m][m];

        for(int i = 0; i <= m-1; i++)
        {
            for(int j = 0; j <= m-1; j++)
            {
                int temp = 0;
                for(int k = 0; k <= m-1; k++)
                {
                    temp = temp + a[i][k]*b[k][j];
                }
                v[i][j] = temp;
            }
        }

        return v;
    }
}
