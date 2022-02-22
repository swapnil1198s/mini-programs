/*
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. 
 * It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */

import java.util.*;
public class MaxWord {
	public String mostCommonWord(String paragraph, String[] banned) {
        String arr[] = paragraph.split("\\W+");
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> wordMap = new HashMap<>();
        
        for(String s: banned){
            bannedSet.add(s);
        }
        String max = "";
        int maxFreq = 0;
        for(String s: arr){
            String lowCase = s.toLowerCase();
            if(bannedSet.contains(lowCase)){
                continue;
            }
            else{
                if(wordMap.containsKey(lowCase)){
                    wordMap.put(lowCase, wordMap.get(lowCase)+1);
                }
                else{
                    wordMap.put(lowCase, 1);
                }
                if(maxFreq<wordMap.get(lowCase)){
                        maxFreq = wordMap.get(lowCase);
                        max = lowCase;
                }
            }
            
        }
            
        return max;
    }
}
