import java.util.ArrayList;
import java.util.List;

public class SortColumns {

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
    public List<Integer> minDeletionSize(String[] arr) {
        List<Integer> deletionList = new ArrayList<Integer>();
        boolean searching = true;
        boolean firstIteration = true;
        int ascii = 0;
        int length = 0;
        int i = 0;
        int n = 0;
        while(searching) {
            if(firstIteration) {
                ascii = arr[0].charAt(0);
                length = arr[0].length();
                firstIteration = false;
                continue;
            }
            if(arr[i].length() != length) {
                deletionList.add(-1);
                return deletionList;
            }
            if(ascii <= (int) arr[i].charAt(n)) {
                ascii = arr[i].charAt(n);
            }
            else {
                ascii = arr[i].charAt(n);
                deletionList.add(n);
                i = 0;
                n++;
            }
            if(i == arr.length - 1) {
                if(n == arr[i].length() - 1) {
                    searching = false;
                }
                else {
                    i = 0;
                    n++;
                }
            }
            else {
                i++;
            }
        }
        return deletionList;
    }

    */

    public static void main(String args[]) {
        SortColumns sc = new SortColumns();
        String[] arr = {"zyx","wvu","tsr"};
        System.out.println(sc.minDeletionSize(arr));
    }
}
