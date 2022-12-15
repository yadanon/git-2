import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("adddasd");
        listOfStrings.add("523");
        listOfStrings.add("12");
        listOfStrings.add("bsdfbsb");
        printMap(getStatisticsOfCharsInList(listOfStrings));
    }

    @SuppressWarnings("java:S106")
    public static void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println("");
    }

    @SuppressWarnings("java:S106")
    public static void printMap(Map<Character, Integer> map) {
        for (Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry);
        }
    }

    public static void addStringToList(List<String> list, String str) {
        list.add(str);
    }

    public static void removeStringFromList(List<String> list, String str) {
        list.remove(str);
    }

    @SuppressWarnings("java:S5413")
    public static void reverseAllStringsInList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String strToReverse = list.get(i);
            list.remove(i);
            list.add(i, reverseString(strToReverse));
        }
    }

    private static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static Map<Character, Integer> getStatisticsOfCharsInList(List<String> list) {
        Map<Character, Integer> statisticsMap = new HashMap<>();
        initializeStatisticsMap(statisticsMap);
        for (String s : list) {
            char[] charsOfWord = s.toLowerCase().toCharArray();
            for (char c : charsOfWord) {
                statisticsMap.computeIfPresent(c, (key, val) -> ++val);
            }
        }
        return statisticsMap;
    }

    private static void initializeStatisticsMap(Map<Character, Integer> map) {
        for (int i = 97; i <= 122; i++) {
            char symbol = (char) i;
            map.put(symbol, 0);
        }
    }


}


