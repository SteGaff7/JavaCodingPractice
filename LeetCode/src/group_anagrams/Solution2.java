package group_anagrams;

/**
 * Given an array of strings, group anagrams together.
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
  ]
  
  Solution too slow
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> groups = new ArrayList<List<String>>();
		
//		Iterate through each string, checking which group it belongs to
		stringloop:
		for (String s : strs) {
			char[] charArray = s.toCharArray();
			
			for (int i = 0; i < groups.size(); i++) {
//				Compare to first anagram in list, iterate through each char of anagram
				char[] anagramCharArray = groups.get(i).get(0).toCharArray();

				if (anagrams(charArray, anagramCharArray)) {
					groups.get(i).add(s);
					continue stringloop;
				}
			}
			
//			Else no matching anagram therefore add a new list with on element to outer list and break
			List<String> anagramGroup = new ArrayList<String>();
			anagramGroup.add(s);
			groups.add(anagramGroup);
		}
	
		return groups;
	}
	
	public static boolean anagrams(char[] a, char[] b) {
//		Must been same length to be anagram
		if (a.length != b.length) {
			return false;
		}
		
		Arrays.parallelSort(a);
		Arrays.parallelSort(b);
		
//		Must have matching chars when sorted
		for (int j = 0; j < a.length; j++) {
			if (a[j] != b[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(s));

	}

}
