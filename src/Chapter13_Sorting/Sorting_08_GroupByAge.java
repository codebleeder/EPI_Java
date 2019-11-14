package Chapter13_Sorting;

import java.util.*;

public class Sorting_08_GroupByAge {
    public static void groupByAge(List<Sorting_08_Person> people){
        Map<Integer, Integer> ageCount = new HashMap<>();
        for (Sorting_08_Person p : people){
            if (!ageCount.containsKey(p.age)){
                ageCount.put(p.age, 1);
            }
            else {
                ageCount.put(p.age, ageCount.get(p.age) + 1);
            }
        }
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kv: ageCount.entrySet()){
            ageToOffset.put(kv.getKey(), offset);
            offset += kv.getValue();
        }
        for (int i = 0; i < people.size(); i++){
            Sorting_08_Person p = people.get(i);
            if (ageCount.get(p.age) > 0){
                int assignedIndex = ageToOffset.get(p.age);
                swap(people, i, assignedIndex);
                ageCount.put(p.age, ageCount.get(p.age) - 1);
                ageToOffset.put(p.age, ageToOffset.get(p.age) + 1);
            }
        }
    }
    public static void swap(List<Sorting_08_Person> people, int a, int b){
        Sorting_08_Person temp = people.get(a);
        people.set(a, people.get(b));
        people.set(b, temp);
    }
    public static void test(){
        List<Sorting_08_Person> people = new ArrayList<>(Arrays.asList(
                new Sorting_08_Person(14, "Greg"),
                new Sorting_08_Person(12, "John"),
                new Sorting_08_Person(11, "Andy"),
                new Sorting_08_Person(13, "Jim"),
                new Sorting_08_Person(12, "Phil"),
                new Sorting_08_Person(13, "Bob"),
                new Sorting_08_Person(13, "Chip"),
                new Sorting_08_Person(14, "Tim")
        ));
        groupByAge(people);
        for(Sorting_08_Person p: people){
            System.out.println(p.toString());
        }
    }
}
