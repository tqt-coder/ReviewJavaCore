package Collection;

import java.util.*;
import java.util.logging.Logger;

public class Exericese {
    private static final List<PersonBean> listPerson = new ArrayList<>();
    private static final List<PersonBean> listPersonNew = new ArrayList<>();


    private static Logger logger = Logger.getLogger(Exericese.class.getName());

    static {
        listPerson.add(new PersonBean(1, "John", 20, new Date("12/2/2000"), "China"));
        listPerson.add(new PersonBean(2, "Nam", 21, new Date("12/2/2001"), "USA"));
        listPerson.add(new PersonBean(3, "Teo", 19, new Date("12/2/2005"), "Aus"));
        listPerson.add(new PersonBean(4, "Lina", 34, new Date("12/2/81"), "VN"));
        listPerson.add(new PersonBean(100, "PhamTran", 10, new Date("12/2/2012"), "UK"));


        listPersonNew.add(new PersonBean(12, "John", 20, new Date("12/2/2000"), "China"));
        listPersonNew.add(new PersonBean(2, "Nam", 21, new Date("12/2/2001"), "USA"));
        listPersonNew.add(new PersonBean(3, "Teo", 19, new Date("12/2/2005"), "Aus"));
        listPersonNew.add(new PersonBean(43, "Lina", 34, new Date("12/2/81"), "VN"));
        listPersonNew.add(new PersonBean(110, "PhamTran", 10, new Date("12/2/2012"), "UK"));

    }

    public int countItem = 0;

    public static void main(String[] args) {
//        checkNewListInOldList();
        Exericese ex = new Exericese();
        ex.sortListAscAge();
        listPerson.forEach(x -> logger.info(String.valueOf(x.getAge()) ));
//
//        // reverse list, loop, recursion
        Collections.reverse(listPerson);

//        listPerson.forEach(x -> logger.info(String.valueOf(x.getAge()) ));

        // sort for birthdate
        ex.sortListAscDateOfBirth();
        Collections.reverse(listPerson);
        listPerson.forEach(x -> logger.info(String.valueOf(x.getDateOfBirth()) ));

        Collections.sort(listPerson, (object_1, object_2)
                -> object_1.getDateOfBirth().compareTo( // sort when wrap or mutiple with -1
                object_2.getDateOfBirth()));
//
//        listPerson.forEach(x -> logger.info(String.valueOf(x.getAge())));
//

        ex.checkTwoListObject(); // check 2 list object with id

    }

    public static void checkNewListInOldList() {
        List<String> oldValues = new ArrayList<>();
        oldValues.add("hello");
        oldValues.add("hi");
        oldValues.add("He");
        oldValues.add("Xin chao");


        List<String> newValues = new ArrayList<>();
        newValues.add("abc");
        newValues.add("hi");
        newValues.add("e");
        newValues.add("Xin chao");
        newValues.add("Xin chao");


        Set<String> generalList = new HashSet<>();
        int count = 0;
        for (String newItem : newValues) {
            if (oldValues.contains(newItem)) {
                count++;
                generalList.add(newItem);
            }

        }
        logger.info(generalList.toString());
        logger.info("Count of items: " + count);
    }

    public void checkTwoListObject() {
        listPersonNew.forEach(x -> {
            if (listPerson.stream().anyMatch(t -> t.getId().equals(x.getId()))) {
                this.countItem++;
            }
        });

        System.out.println(this.countItem);
    }

    // input :string
    // str2 = "abcd

    public void sortListAscAge() {
        for (int i = 0; i < listPerson.size() - 1; i++) {
            for (int j = i + 1; j < listPerson.size(); j++) {
                if (listPerson.get(j).getAge() < listPerson.get(i).getAge()) {
                    PersonBean personTemp = listPerson.get(i);
                    listPerson.indexOf(personTemp);

                    listPerson.set(i, listPerson.get(j));
                    listPerson.set(j, personTemp);
                }
            }
        }


    }

    public void sortListAscDateOfBirth() {
        for (int i = 0; i < listPerson.size() - 1; i++) {
            for (int j = i + 1; j < listPerson.size(); j++) {
                Date firstDate = listPerson.get(i).getDateOfBirth();
                Date secondDate = listPerson.get(j).getDateOfBirth();
                if (firstDate.compareTo(secondDate) > 0) {
                    PersonBean personTemp = listPerson.get(i);
                    listPerson.set(i, listPerson.get(j));
                    listPerson.set(j, personTemp);
                }
            }
        }
    }
}
