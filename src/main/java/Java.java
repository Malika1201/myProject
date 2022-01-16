import java.util.Arrays;
import java.util.Scanner;

public class Java {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] words = {input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine()};


        //TODO: Write your code below
        String [] words2 = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            words2[i] = "" + first + last;
        }
        System.out.println(Arrays.toString(words2));
    }
}




           /* char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            String result = "" + first + last + ", ";
            if (i == words[i].length()-1) {

            }
                //result.trim()
                System.out.print(result);
        }

        /*String[] words2 = new String[words.length];

        for (int i = 0, j=0; i <= words2.length-1; i++,j++) {
            words2[i]=words[j].charAt(0)+""+words[j].charAt(words[j].length()-1);
        }

        System.out.println(Arrays.toString(words2));*/

