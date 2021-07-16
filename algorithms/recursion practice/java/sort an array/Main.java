import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>((Arrays.asList(4, 2, 1, 9, 6, 7, 5)));
        sort(list);
        display(list);
    }

    static void sort(List<Integer> list) {
        /** base condition */
        if (list.size() == 1) { /** if list has only one element then it's already sorted */
            return;
        }
        /** hypothesis */
        Integer lastElement = list.remove(list.size() - 1);
        sort(list);
        /** Induction */
        insert(list, lastElement);
    }

    static void insert(List<Integer> list, Integer element) {
        /** inserting element into it's correct location in a sorted list */
        /** base condition */
        if (list.size() == 0 || list.get(list.size() - 1) <= element) { /**
                                                                         * if list is empty or last element is less than
                                                                         * or equal to new element then push into list
                                                                         */
            list.add(element);
            return;
        }
        /** hypothesis */
        Integer lastElement = list
                .remove(list.size() - 1); /**
                                           * working on smaller inputs; so taking out the last element and inserting the
                                           * new element into it's correct position in smaller sorted list
                                           */
        insert(list, element);
        /** Induction */
        list.add(lastElement); /**
                                * adding the removed element back at the end as it was the largest one in the
                                * sorted List
                                */
        return;
    }

    static void display(List<Integer> list) {
        for (Integer element : list)
            System.out.print(element + " ");
    }
}
