package task3;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/*
* Create a listMapCompare() method of the MyUtils class to compare the contents of a list of strings and the values of a map.

For example, for a given list

[aa, bb, aa, cc]

and map

{1=cc, 2=bb, 3=cc, 4=aa, 5=cc}

you should get true.
* */
public class MyUtils {

    /*yes*/
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        // Code
        Set<String> listValues = new HashSet<>(list);

        Set<String> mapValues = new HashSet<>();
        for (String key : map.keySet()) {
            mapValues.add(map.get(key));
        }

        return listValues.containsAll(mapValues) && mapValues.containsAll(listValues);

    }

    /*yes*/
    public boolean listMapCompare2(List<String> list, Map<String, String> map) {
        Set<String> mapValues = new HashSet<>();
        for (String key : map.keySet()) {
            mapValues.add(map.get(key));
        }

        return list.containsAll(mapValues) && mapValues.containsAll(list);
    }
}
