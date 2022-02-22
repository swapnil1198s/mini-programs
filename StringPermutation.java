/*
 * Give string s and string b
 * such that s.length < b.length
 * Find the locations of all permutations of s that occur in b
 * 
 */

import java.util.*;
public class StringPermutation {
	public static void init_sMap(String s, HashMap<Character, Integer> sMap) {
		int len = s.length();
		for(int i = 0; i<len; i++) {
			char c = s.charAt(i);
			if(sMap.containsKey(c)) {
				sMap.put(c, sMap.get(c)+1);
			}
			else {
				sMap.put(c, 1);
			}
		}
	}
	public static void findPermutations(String s, String b) {
		HashMap<Character, Integer> sMap = new HashMap<>();
		HashMap<Character, Integer> bMap = new HashMap<>();
		int sLen = s.length();
		int bLen = b.length();
		init_sMap(s, sMap);
		int p1 = 0;
		int p2 = sLen -1;
		while(p2<bLen) {
			if(!sMap.containsKey(b.charAt(p1))) {
				++p1;
				++p2;
			}
			else if(!sMap.containsKey(b.charAt(p2))) {
				p1 = p2+1;
				p2 = p1+sLen-1;
			}
			else {
				bMap.put(b.charAt(p1), 1);
				bMap.put(b.charAt(p2), 1);
				for(int i=p1+1; i<p2;i++ ) {
					char c = b.charAt(i);
					if(!sMap.containsKey(c)) {
						p1 = i+1;
						p2 = p1 + sLen -1;
						break;
					}
					else {
						if(!bMap.containsKey(c)) {
							bMap.put(c, 1);
						}
						else {
							bMap.put(c,  bMap.get(c)+1);
							if(bMap.get(c)>sMap.get(c)) {
								p1 = i+1;
								p2 = p1 +sLen -1;
								break;
							}
						}
					}
				}
				if((p2-p1)==(sLen-1)){
					System.out.println("Permutation from: " + p1 + " to " + p2);
				}
				p1 += 1;
				p2 += 1;
				bMap.clear();
			}
		}
		
	}
	public static void main(String args[]) {
		String s = "aabc";
		String b = "abcdaabcaadaabc";
		findPermutations(s, b);
	}
}
