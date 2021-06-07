import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private int tryinSth(String a){
        //int a = 7; DNC
        int s;

        Predicate<Integer> myPredicate = b -> { // a already defined in the scope
            b = 0; // b already defined in the scope
            b = 5;
            // s = 8; s is not effectively final
            // a = 3; a is not effectively final
            int c = 0;
            return b==c;
        };

        return Integer.parseInt(a);
    }

/*    private void variables (int a){
        int b = 1;

        Predicate<Integer> myPredicate = a -> { // a already defined in the scope
            int b = 0; // b already defined in the scope
            int c = 0;
            return b==c;
        };

    }
*/

    public static void main(String[] args) {

        Main myMain = new Main();
        System.out.println(myMain.tryinSth(6 +""));

        List<String> stringList = new ArrayList<>();
        stringList.add("semir");
        stringList.add("ahmet");
        stringList.add("ali");

        Comparator<String> stringComparator = (s1, s2) -> s1.compareTo(s2); //  String::compareTo; alternative
        Consumer<String> stringConsumer = (s1) ->  System.out.println(s1.charAt(2));
        Consumer<Integer> integerConsumer = (s1) -> { System.out.println(s1*s1); };


        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(6);

        Map<String, Integer> animalLegNumberMap = new HashMap<>();
        animalLegNumberMap.put("eagle", 2);
        animalLegNumberMap.put("Giraffe", 4);
        animalLegNumberMap.put("Snake", 0);
        animalLegNumberMap.put("Myriapoda", 40);

        System.out.println("*** Consumer ***********Calling Foreach on Integer List**************");
        myMain.foreach(integerList, integerConsumer);
        System.out.println("*** Comparator ***********Calling Sort on String List**************");
        myMain.sort(stringList,stringComparator);
        System.out.println(stringList);
        System.out.println("*** Biconsumer ***********Calling Foreach on Map**************");
        animalLegNumberMap.forEach((k,v) -> System.out.print(k +": " + v +"\t"));


    }

    private void sort(List<String> stringList, Comparator<String> stringComparator){
        stringList.sort(stringComparator);
    }

    private void foreach(List<Integer> integerList, Consumer<Integer> integerConsumer){
        integerList.forEach(integerConsumer);
    }

}
