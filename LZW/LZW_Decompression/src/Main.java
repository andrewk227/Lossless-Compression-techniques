import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String Decompression(String Sequence){
        String output = "";
        int tablePos = 128;
        Map<Integer, String> Table = new HashMap<Integer, String>();
        int positionInt;
        String PositionSequence = "";
        String currentSequence = "";
        String previousSequence="";
        String addedInTable = "";
        boolean unknown = false;

        for(int i=0 ; i< Sequence.length() ; i++)
        {
            if (Sequence.charAt(i) == ' ' || i == Sequence.length() -1)
            {
                // reading last Character
                if(i == Sequence.length() -1)
                {
                    PositionSequence += Sequence.charAt(i);
                }

                positionInt = Integer.parseInt(PositionSequence);
                if(positionInt < 128)
                {
                    output = output +  (char) positionInt ;

                    currentSequence += (char) positionInt;
                }
                else
                {
                    if(Table.containsKey(positionInt))
                    {
                        unknown = false;
                        output = output + (String)Table.get(positionInt) ;
                        currentSequence = (String)Table.get(positionInt);
                    }
                    // Unknown in the Table
                    else
                    {
                        unknown = true;
                        if(!previousSequence.isEmpty())
                        {
                            addedInTable = previousSequence + previousSequence.charAt(0);
                            Table.put(tablePos , addedInTable);
                            tablePos++;
                            output = output + addedInTable ;
                        }
                        currentSequence = addedInTable;
                    }


                }

                if(!previousSequence.isEmpty() && unknown == false)
                {
                    addedInTable = previousSequence + currentSequence.charAt(0);
                    Table.put(tablePos , addedInTable);
                    tablePos++;
                }



                previousSequence = currentSequence;
                currentSequence= "";
                PositionSequence ="";
                addedInTable = "";


            }
            else {
                PositionSequence += Sequence.charAt(i);
            }


        }


        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Text;
        //"65 66 65 128 128 129 131 134 130 129 66 138 139 138"

        Text = scanner.nextLine();
        String output = Decompression(Text);
        System.out.println(output);
    }
}