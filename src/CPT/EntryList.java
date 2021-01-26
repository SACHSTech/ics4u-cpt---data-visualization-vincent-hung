package CPT;

import java.lang.reflect.Array;
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
        ArrayList<Entry> searchedlist = null;
        for (int intx = 0 ; intx < intsize ; intx++) {
            if (List.contains(searchitem)) {
                searchedlist.add(List.get(intx));
            }
        }

    return searchedlist;
    }
}
