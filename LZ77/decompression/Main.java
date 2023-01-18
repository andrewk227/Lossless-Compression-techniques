import java.util.Scanner;

public class Main
{
    public static String decompression()
    {
        //00a00b21a32b53b22b55b11a
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String compressed = input;

        String decompressed = "";
        int position = 0;
        int length = 0;
        char symbol;
        int counter = 0;

        for (int i = 0; i < compressed.length(); i+=3)
        {
            position = (char)(compressed.charAt(i) - '0');
            length = (char)(compressed.charAt(i + 1) - '0');
            symbol = compressed.charAt(i + 2);

            if (position == 0)
            {
                decompressed += symbol;
            }
            else
            {
                counter = 0;
                for (int j = decompressed.length() - position; counter != length; j++)
                {
                    decompressed += decompressed.charAt(j);
                    counter++;
                }
                if (symbol == '*')
                    continue;
                else
                    decompressed += symbol;
            }

        }

        return decompressed;
    }


    public static void main(String[] args)
    {

        System.out.println(decompression());

        return;
    }
}
