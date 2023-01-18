import java.util.Scanner;

public class Main
{
    public static String Compress(int position, int length)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String text = input;
        String output = "";

        //ABAABABAABBBBBBBBBBBBA

        int pos = 0;
        int len = 0;
        char symbol = text.charAt(0);

        int start = 0;
        int h = 0;
        int k = 0;
        int l = 0;
        int seq = 0;
        int max = 0;
        int z = 0;
        String out = "";

        out = pos + " " + len + " " + symbol;
        System.out.println(out);

        for (int i = 1; i < text.length(); i++)
        {
            start = i - position;
            if (start < 0)
                start = 0;

            boolean found = false;
            for (z = 0; z < i; z++)
            {
                if (text.charAt(z) == text.charAt(i))
                {
                    found = true;
                }
            }
            if (found == true)
            {
                while (start < i)
                {
                    seq = 0;

                    if (text.charAt(start) == text.charAt(i))
                    {
                        seq++;
                        h = start + 1;
                        k = i + 1;
                        while (h < i && k < text.length() && (k - i) < length)
                        {
                            if (text.charAt(h) == text.charAt(k))
                            {
                                seq++;
                                h++;
                                k++;
                            }
                            else
                            {
                                break;
                            }
                        }
                        if (max <= seq)
                        {
                            max = seq;
                            pos = i - start;
                            len = seq;
                            if(k >= text.length())
                                symbol = '*';
                            else
                                symbol = text.charAt(k);
                        }
                    }
                    start++;

                }
            }
            else
            {
                out = "0" + " " + "0" + " " + text.charAt(i);
                System.out.println(out);
                continue;
            }
            if(k < text.length())
            {
                out = pos + " " + len + " " + symbol;
                System.out.println(out);
            }
            else
            {
                out = pos + " " + len + " " + "*";
                System.out.println(out);
            }
            max = 0;
            i = i + len;

        }

        return "";
    }

    public static void main(String[] args)
    {

        System.out.println(Compress(5,5));

        return;
    }
}

