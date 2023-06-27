package interviewquestions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,57,9,152,11,193,2,58,5,7,131,9);
        int[] nums = new int[]{4,2,57,9,152,11,193,2,58,5,7,131,9};
        String str = "Java articles are Awesome";
        findOutAllEvenNumbers(list);
        findOutAllNumbersStartingWith1(list);
        findOutAllDuplicateNumbers(list);
        findFirstNumbers(list);
        findTotalNumbers(list);
        findMaximumNumber(list);
        findFirstNonRepeatedCharacter(str);
        findFirstRepeatedCharacter(str);
        sortData(list);
        sortDataInReversedOrder(list);
        containsDuplicate(nums);
        getCurrentDateTime();
        concateTwoStreams(Arrays.asList("Java", "8"),Arrays.asList("explained", "through", "programs"));
        performCubeAndPrintGreaterThan50(list);
        sortAndConvertToStreams(nums);
        mapToUpperCase(Arrays.asList("explained", "through", "programs"));
        conertListToMapConsideringDuplicatedKeys();
        countEachElement(Arrays.asList("explained", "through", "programs","explained"));
        findOnlyDuplicateElementsWithItsCount(Arrays.asList("explained", "through", "programs","explained"));
        checkNonNullObjectUsingOptional();
        findMaxElement(nums);
        findCountOfChars("string data to count each character");
    }

    /*
    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
     */
    public static void findOutAllEvenNumbers(List<Integer> integerList){
        System.out.println("findOutAllEvenNumbers : ");
        List<Integer> integers = integerList.stream()
                .filter(integer -> integer%2==0)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    /*
    Given a list of integers, find out all the numbers starting with 1 using Stream functions?
     */
    public static void findOutAllNumbersStartingWith1(List<Integer> integerList){
        System.out.println("findOutAllNumbersStartingWith1 : ");
        List<Integer> integers = integerList.stream()
                .map(integer -> integer + "")
                .filter(integer -> integer.startsWith("1"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    /*
    How to find duplicate elements in a given integers list in java using Stream functions?
     */
    public static void findOutAllDuplicateNumbers(List<Integer> integerList){
        System.out.println("findOutAllDuplicateNumbers : ");
        Set<Integer> set = new HashSet<>();
        List<Integer> integers = integerList.stream()
                .filter(integer -> !set.add(integer))
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    /*
    Given the list of integers, find the first element of the list using Stream functions?
     */
    public static void findFirstNumbers(List<Integer> integerList){
        System.out.println("findFirstNumbers : ");
        integerList.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    /*
    Given a list of integers, find the total number of elements present in the list using Stream functions?
     */
    public static void findTotalNumbers(List<Integer> integerList){
        System.out.println("findTotalNumbers : ");
        System.out.println(integerList.stream().count());
    }

    /*
    Given a list of integers, find the maximum value element present in it using Stream functions?
     */
    public static void findMaximumNumber(List<Integer> integerList){
        System.out.println("findMaximumNumber : ");
        integerList.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
        integerList.stream()
                .max(Integer::compare)
                .ifPresent(System.out::println);

    }

    //Given a String, find the first non-repeated character in it using Stream functions?
    public static void findFirstNonRepeatedCharacter(String input){
        System.out.println("findFirstNonRepeatedCharacter : ");
        Set<Integer> set = new HashSet<>();
        Character character = input.chars()
                .mapToObj(currentChar -> Character.toLowerCase(Character.valueOf((char) currentChar)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(character);
    }

    //Given a String, find the first repeated character in it using Stream functions?
    public static void findFirstRepeatedCharacter(String input){
        System.out.println("findFirstRepeatedCharacter : ");
        Set<Character> set = new HashSet<>();
        Character character = input.chars()
                .mapToObj(currentCharacter -> Character.toLowerCase(Character.valueOf((char) currentCharacter)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(character);
    }

    //Given a list of integers, sort all the values present in it using Stream functions?
    public static void sortData(List<Integer> myList) {
        System.out.println("sortData : ");
        myList.stream()
                .sorted()
                .forEach(s -> System.out.print(s +" "));
        System.out.println();
    }

    //Given a list of integers, sort all the values present in it in descending order using Stream functions?
    public static void sortDataInReversedOrder(List<Integer> myList) {
        System.out.println("sortDataInReversedOrder : ");
        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(s -> System.out.print(s +" "));
        System.out.println();
    }

    //Given an integer array nums, return true if any value appears at least twice in the array, and return
    // false if every element is distinct.
    public static void containsDuplicate(int[] nums) {
        System.out.println("containsDuplicate : ");
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .toList();
        Set<Integer> set = new HashSet<>(list);
        if(set.size()==list.size())
            System.out.println(false);
        else
            System.out.println(true);
    }

    //How will you get the current date and time using Java 8 Date and Time API?
    public static void getCurrentDateTime() {
        System.out.println("getCurrentDateTime : ");
        System.out.println("LocateDate : "+ LocalDate.now());
        System.out.println("LocateTime : "+ LocalTime.now());
        System.out.println("LocalDateTime : "+ LocalDateTime.now());
    }

    //Write a Java 8 program to concatenate two Streams?
    public static void concateTwoStreams(List<String> strings1, List<String> strings2) {
        System.out.println("concateTwoStreams : ");
        Stream<String> stream = Stream.concat(strings1.stream(),strings2.stream());
        stream.forEach(s -> System.out.print(s+" "));
        System.out.println();
    }

    //Java 8 program to perform cube on list elements and filter numbers greater than 50.
    public static void performCubeAndPrintGreaterThan50(List<Integer> integers) {
        System.out.println("performCubeAndPrintGreaterThan50 : ");
        List<Integer> integerList = integers.stream()
                .map(i -> i*i*i)
                .filter(j ->j>50)
                .toList();
        System.out.println(integerList);
    }

    //Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    public static void sortAndConvertToStreams(int[] nums) {
        System.out.println("sortAndConvertToStreams : ");
        Arrays.parallelSort(nums);
        Arrays.stream(nums).forEach(s -> System.out.print(s+" "));
        System.out.println();
    }

    //How to use map to convert object into Uppercase in Java 8
    public static void mapToUpperCase(List<String> strings) {
        System.out.println("mapToUpperCase : ");
        List<String> strings1 = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strings1);
    }

    //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    public static void conertListToMapConsideringDuplicatedKeys() {
        System.out.println("conertListToMapConsideringDuplicatedKeys : ");
        List<Notes> notesList =  Arrays.asList(
                new Notes(1, "note1", 11),
                new Notes(2, "note2", 22),
                new Notes(3, "note3", 33),
                new Notes(4, "note4", 44),
                new Notes(5, "note5", 55),
                new Notes(6, "note4", 66)
        );
        Map<String,Long> map = notesList.stream()
                .sorted(Comparator.comparing(Notes::getTag).reversed())
                .collect(Collectors.toMap(Notes::getName , Notes::getTag,
                        (oldValue, newValue) -> oldValue,LinkedHashMap::new));

        System.out.println(map);
    }

    //How to count each element/word from the String ArrayList in Java8?
    public static void countEachElement(List<String> strings) {
        System.out.println("countEachElement : ");
        Map<String,Long> map = strings.stream()
                .collect(Collectors.groupingBy(string -> string,Collectors.counting()));
        System.out.println(map);
    }

    //How to find only duplicate elements with its count from the String ArrayList in Java8?
    public static void findOnlyDuplicateElementsWithItsCount(List<String> strings) {
        System.out.println("findOnlyDuplicateElementsWithItsCount : ");
        Map<String,Long> map = strings.stream()
                .filter(string -> Collections.frequency(strings,string)>1)
                .collect(Collectors.groupingBy(string -> string,Collectors.counting()));
        System.out.println(map);
    }

    //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
    public static void checkNonNullObjectUsingOptional() {
        System.out.println("checkNonNullObjectUsingOptional : ");
        List<Notes> notesList =  Arrays.asList(
                new Notes(1, "note1", 11),
                new Notes(2, "note2", 22),
                new Notes(3, "note3", 33),
                new Notes(4, "note4", 44),
                new Notes(5, "note5", 55),
                new Notes(6, "note4", 66)
        );
        Optional.ofNullable(notesList)
                        .orElseGet(Collections::emptyList)
                                . stream().filter(Objects::nonNull)
                        .map(notes -> notes.getName())
                        .forEach(System.out::println);

    }

    //Write a Program to find the Maximum element in an array?
    public static void findMaxElement(int[] nums) {
        System.out.println("findMaxElement : ");
        System.out.println(Arrays.stream(nums).max().getAsInt());
    }

    //Write a program to print the count of each character in a String?
    public static void findCountOfChars(String s) {
        System.out.println("findCountOfChars : ");
        Map<String, Long> map = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
    }
}
