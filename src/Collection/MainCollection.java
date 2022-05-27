package Collection;

import java.util.*;
import java.util.logging.Logger;


public class MainCollection {
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(MainCollection.class.getName());

        HashMap<Object, Object> everyThingMap = new HashMap<>();

        Object numberInteger = 100;
        Object objectString = "hello";
        List<List> nestList = new ArrayList<List>();

        nestList.add(Arrays.asList(1, 2, 3, 4, -100));
        nestList.add(Arrays.asList("a", " ", "hello"));

        everyThingMap.put(numberInteger, objectString);
        everyThingMap.put(objectString, numberInteger);
        everyThingMap.put("NestestList", nestList);


        List<List> subIntegerList = new ArrayList<>();
        List<List> subIntegerList2 = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : everyThingMap.entrySet()) {
            if (entry.getKey() == "NestestList") {
                subIntegerList = (List<List>) entry.getValue();
                subIntegerList.get(0).forEach(System.out::println);
                break;
            }
        }

        // Another method
        Set set = everyThingMap.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if (me.getKey().equals("NestestList")) {
                ((List<List>) me.getValue()).get(0).forEach(System.out::println);

            }

        }

        LOGGER.info(everyThingMap.get("NestestList").toString());

    }

}
