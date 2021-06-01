package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* Create a createNotebook() method of the MyUtils class to create
a new map with name as key and phone list as value.
The method receives a map with phone as key and name as value.

For example, for a given map

{
    0967654321=Petro,
    0677654321=Petro,
    0501234567=Ivan,
    0970011223=Stepan,
    0631234567=Ivan
}

you should get

{
    Ivan=[0501234567, 0631234567],
    Petro=[0967654321, 0677654321],
    Stepan=[0970011223]
}

*/
public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> map = new HashMap<>();

        for (String phone : phones.keySet()) {
            String name = phones.get(phone);

            if (map.containsKey(name)) {
                map.get(name)           // List<String>
                        .add(phone);    // add to list
            } else {
                map.put(name, new ArrayList<>(){{add(phone);}});
            }

        }

        return map;
    }
}
