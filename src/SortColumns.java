import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortColumns {

    /*
        * params:
            * String[] arr
        * description: determines which columns in the array are not in alphabetical order
        * return: List<Integer>
    */
    public List<Integer> minDeletionSize(String[] arr) {
        List<Integer> deletionList = new ArrayList<Integer>();
        int elementLength = arr[0].length();
        for(int col = 0; col < elementLength; col++) {
            int ascii = 0;
            for(int i = 0; i < arr.length; i++) {
                String element = arr[i];
                if(element.length() != elementLength) {
                    deletionList.add(-1);
                    return deletionList;
                }
                else if(ascii <= (int) element.charAt(col)) {
                    ascii = (int) element.charAt(col);
                }
                else {
                    ascii = (int) element.charAt(col);
                    if(!deletionList.contains(col)) {
                        deletionList.add(col);
                    }
                }
            }
        }
        return deletionList;
    }

    /*
        * params: none
        * description: gets array inputs from user
        * return: String[]
    */
    public String[] getUserInputs() {
        ArrayList <String> inputs = new ArrayList <String>();
        Scanner s = new Scanner(System.in);
        boolean gettingInputs = true;
        while(gettingInputs) {
            System.out.println("Current array: " + inputs.toString());
            System.out.println("Enter a string to be added to the array, or enter '-1' to use the current array");
            String input = s.next();
            if(input.equals("-1")) {
                gettingInputs = false;
            }
            else if(isAlphabetical(input)) {
                inputs.add(input);
            }
            else {
                System.out.println("Input must only contain alphabetical characters. Try again.");
            }
        }
       String[] arrInputs = new String[inputs.size()];
        for(int i = 0; i < arrInputs.length; i++) {
            arrInputs[i] = inputs.get(i);
        }
        if(arrInputs.length == 0) {
            arrInputs = new String[1];
            arrInputs[0] = "";
        }
        return arrInputs;
    }

    /*
        * params:
            * String input - input from the user
        * description: determines whether or not string is an alphabetical character or not
        * return: boolean
    */
    private boolean isAlphabetical(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SortColumns sc = new SortColumns();
        System.out.println("~~ SORT COLUMNS ~~");
        String[] arr = sc.getUserInputs();
        System.out.println("Your inputs: " + Arrays.toString(arr));
        System.out.println("Result: " + sc.minDeletionSize(arr));
    }
}
