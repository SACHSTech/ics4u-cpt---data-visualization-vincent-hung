package CPT;

import java.util.ArrayList;

public class EntryList {

    private ArrayList<Entry> List;
    private int intsize;

    public EntryList(ArrayList<Entry> givenList) {
        this.List = givenList;
        intsize = givenList.size();
    }

    public ArrayList<Entry> getList() {
        return List;
    }

    public int getSize() {
        return intsize;
    }

    public void setDataPoints(ArrayList<Entry> ListChange) {
        List = ListChange;
    }

    public void addEntry(Entry newEntry) {
        List.add(newEntry);
    }

    public ArrayList<Entry> search(String searchitem) {
        ArrayList<Entry> searchedlist = new ArrayList<Entry>();
        for (Entry entries : List) {
            if (List.contains(searchitem)) {
                searchedlist.add(entries);
            }
        }

    return searchedlist;
    }

    public static ArrayList<Double> grabAllScores(ArrayList<Entry> EntryList) {
        ArrayList<Double> temp = new ArrayList<Double>();
        for (Entry entries : EntryList) {
            temp.add(entries.getScore());
        }
        return temp;
    }
}
