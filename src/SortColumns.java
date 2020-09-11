import java.util.ArrayList;
import java.util.List;

public class SortColumns {

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

    public static void main(String args[]) {
        SortColumns sc = new SortColumns();
        String[] arr = {"cba", "daf", "ghi"};
        System.out.println(sc.minDeletionSize(arr));
    }
}
