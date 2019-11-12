package Chapter13_Sorting;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_03_EliminateDuplicate {
    public static void eliminateDuplicate(List<Name> nameList){
        Collections.sort(nameList);
        int writeIndex = 1;
        for (int i = 1; i < nameList.size(); i++){
            if (!nameList.get(i).first.equals(nameList.get(writeIndex).first)){
                writeIndex += 1;
                nameList.set(writeIndex, nameList.get(i));
            }
        }
        //writeIndex++;
        nameList.subList(++writeIndex, nameList.size()).clear();
    }
    public static void test(){
        List<Name> names = new ArrayList<>();
        names.add(new Name("Ian", "Botham"));
        names.add(new Name("David", "Gower"));
        names.add(new Name("Ian", "Bell"));
        names.add(new Name("Ian", "Chappell"));

        eliminateDuplicate(names);
        for (Name n: names){
            System.out.println(n.toString());
        }
    }
}
