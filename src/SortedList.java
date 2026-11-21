import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list = new ArrayList<>();
    public SortedList() {

    }
    public int size(){
        return list.size();
    }
    public String get(int index){
        return list.get(index);
    }
    @Override
    public String toString(){
        return list.toString();
    }

    public int binarySearch(String target){
        int low = 0;
        int high = list.size() - 1;
        while (low <= high){
            int mid = (low + high)/2;
            int cmp = target.compareTo(get(mid));
            if (cmp == 0){
                return mid;
            }
            else if (cmp < 0){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;

    }
    public void add(String item){
        int index = binarySearch(item);
        list.add(index, item);
    }

}

