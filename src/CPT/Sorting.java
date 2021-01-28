package CPT;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** 
 * Sort class file
 * 
 * @author V.Hung
 * 
 * 
 */
public class Sorting {
    public static  ObservableList<HappinessReport> sort(ObservableList<HappinessReport> load, String GLorLG) {
        ObservableList<HappinessReport> sortingarray = FXCollections.observableArrayList(load);
        HappinessReport[] temp = new HappinessReport[sortingarray.size()];
        mergeSortHelper(sortingarray, 0, (load.size() - 1), temp, GLorLG);
        return sortingarray;
    }

    private static void mergeSortHelper(ObservableList<HappinessReport> sortingarray, int from, int to, HappinessReport[] temp, String GLorLG) {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(sortingarray, from, mid, temp, GLorLG);
            mergeSortHelper(sortingarray, mid + 1, to, temp, GLorLG);
            merge(sortingarray, from, mid, to, temp, GLorLG);
        }
    }

    private static void merge(ObservableList<HappinessReport> sortingarray, int from, int mid, int to, HappinessReport[] temp, String GLorLG) {
        int lefttracker = from;
        int righttracker = mid + 1;
        int temptracker = from;
        if (GLorLG.equals("GL")) {
            while (lefttracker <= mid && righttracker <= to) {
                    if (sortingarray.get(temptracker).getRanking() > sortingarray.get(righttracker).getRanking()) {
                    temp[temptracker] = sortingarray.get(lefttracker);
                    //sortingarray.set(temptracker,sortingarray.get(lefttracker));
                    lefttracker++;
                    } else {
                    temp[temptracker] = sortingarray.get(righttracker);
                    //sortingarray.set(temptracker,sortingarray.get(righttracker));
                    righttracker++;
                    //System.out.println(righttracker);
                    }
                temptracker++;
                }
            while (lefttracker <= mid) {
                temp[temptracker] = sortingarray.get(lefttracker);
                lefttracker++;
                temptracker++;
            }
            while (righttracker <= to) {
                //sortingarray.set(temptracker,sortingarray.get(righttracker));
                temp[temptracker] = sortingarray.get(righttracker);
                righttracker++;
                temptracker++;
            }

            for (temptracker = from ; temptracker <= to ; temptracker++) {
            sortingarray.set(temptracker, temp[temptracker]);
            }
        }
        if (GLorLG.equals("LG")) {
            while (lefttracker <= mid && righttracker <= to) {
                    if (sortingarray.get(temptracker).getRanking() < sortingarray.get(righttracker).getRanking()) {
                    temp[temptracker] = sortingarray.get(lefttracker);
                    //sortingarray.set(temptracker,sortingarray.get(lefttracker));
                    lefttracker++;
                    } else {
                    temp[temptracker] = sortingarray.get(righttracker);
                    //sortingarray.set(temptracker,sortingarray.get(righttracker));
                    righttracker++;
                    //System.out.println(righttracker);
                    }
                temptracker++;
                }
            while (lefttracker <= mid) {
                temp[temptracker] = sortingarray.get(lefttracker);
                lefttracker++;
                temptracker++;
            }
            while (righttracker <= to) {
                //sortingarray.set(temptracker,sortingarray.get(righttracker));
                temp[temptracker] = sortingarray.get(righttracker);
                righttracker++;
                temptracker++;
            }

            for (temptracker = from ; temptracker <= to ; temptracker++) {
            sortingarray.set(temptracker, temp[temptracker]);
            }
        }
    }
}
