package com.intelizest;

/**
 * @author : Sathish Kumar S
 * @version : 1.0
 * @javaVersion : 11.0
 * @ideused : Intelija
 * @Features :
 *          1. Designed with Single Responsibility Design Strategy.
 *              Each method will perform max 1 task.
 *          2. Used Java 1.8 Streams features extensively.
 *          3. Memory Efficient : Used method local variable.
 *              Once method is over minor GC will clear the memory
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className : VowelCounter
 * @description : This classed used to count vowel in each words in a given String and
 *                print the maximum vowel count of first 3 words.
 *                Example : A tournament is a competition involving many teams.
 *                Result :
 *                competition - 5
 *                tournament - 4
 *                involving - 3
 */
public class VowelCounter {

    int maxVowelCount = 0;

    public VowelCounter(int maxVowelCount) {
        this.maxVowelCount = maxVowelCount;
    }

    public static void main(String[] args) {
        VowelCounter vowelCounter  = new VowelCounter(3);
        vowelCounter.countAndPrintVowel();
    }

    private void countAndPrintVowel(){
        System.out.println("Welcome To Vowel Counter. Enter The String to count Vowels.");
        String vowelCountSt = getInputFromConsole();
        final Map<Integer,List<String>> vowelCountMap = getVowelCountAsMap(vowelCountSt);
        printMaxVowelCount(maxVowelCount, vowelCountMap);
    }

    /**
     * Get the string from User through console to count vowels.
     * @return string :
     */
    private String getInputFromConsole() {
        Scanner inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }

    /**
     * Count vowels [a,e,i,o,u] from the given string
     * @param vowelCountSt : word to count vowel.
     * @return Count as Integer.
     */

    private Integer countVowel(String vowelCountSt) {
        char[] chArrStr = vowelCountSt.toLowerCase().toCharArray();
        int vowelCount = 0;
        for(char c : chArrStr) {
            if(isVowel(c)) {
                vowelCount++;
            }
        }
        return vowelCount;
    }


    /**
     * Check particular character is Vowel Or Not.
     * @param c : Input character to check vowel
     * @return  Boolean :  True vowel else false.
     */

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c== 'i' || c == 'o' || c == 'u';
    }

    /**
     * Get vowel Count String as Map which contains vowel count and List of words.
     * @param vowelCountSt
     * @return
     */

    private Map<Integer,List<String>> getVowelCountAsMap(String vowelCountSt) {
        final Map<Integer,List<String>> vowelCountMap = new TreeMap<>(Collections.reverseOrder());
        Arrays.stream(vowelCountSt.split(" ")).forEach(s -> {
            Integer vowelCount = this.countVowel(s);
            List<String> vowelStList = null;
            if(vowelCountMap.containsKey(vowelCount)) {
                vowelStList = vowelCountMap.get(vowelCount);
            } else {
                vowelStList = new ArrayList<>();
                vowelCountMap.put(vowelCount,vowelStList);
            }
            vowelStList.add(s);
        });
        return vowelCountMap;
    }

    /**
     *
     * @param maxWordsCount
     * @param vowelCountMap
     */
    private void printMaxVowelCount(int maxWordsCount, Map<Integer,List<String>> vowelCountMap) {
        vowelCountMap.entrySet().stream().limit(maxWordsCount).forEach(entry -> {
            String st = entry.getValue().stream().collect(Collectors.joining(","));
            Integer key = entry.getKey();
            System.out.println(st + " - " + key );
        });
    }
}
