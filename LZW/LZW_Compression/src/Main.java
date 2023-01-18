import java.util.*;

public class Main {

    // Function to return the key with the Value
    public static int findPos(Map<Integer , String> Table , String value){
        int Pos = 0;

        for (Map.Entry<Integer, String> entry : Table.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                Pos = entry.getKey();
                break;
            }
        }

        return Pos;
    }

    public static String Compress(String Text) {
        String output = "";
        int Pos;
        int tablePos = 128;
        Map<Integer, String> Table = new HashMap<Integer, String>();
        String Sequence = "";

        for (int i = 0; i < Text.length(); i++) {

            // Seq is a single char
            Sequence += Text.charAt(i);
            Pos = (int) Text.charAt(i);

            for (int j = i + 1; j < Text.length(); j++) {
                Sequence += Text.charAt(j);

                // stopping condition for j
                if(!Table.containsValue(Sequence))
                {
                    Table.put(tablePos , Sequence);
                    tablePos++;
                    Sequence = Sequence.substring(0 , Sequence.length()-1);
                    i = j-1;
                    break;
                }
                else {
                    Pos = findPos(Table, Sequence);
                }

                // STOP IF j reaches the end
                if(j == Text.length() -1)
                {
                    i = j;
                }
            }

            output = output + String.valueOf(Pos) + " ";
            Sequence = "";
        }


        return output;
    }

    public static void main(String[] args) {
        String Text ="";
                //"ABAABABBAABAABAAAABABBBBBBBB";

        Scanner scanner = new Scanner(System.in);
        Text = scanner.nextLine();

        String output = Compress(Text);
        System.out.println(output);
    }
}