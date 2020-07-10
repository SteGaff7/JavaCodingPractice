package group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> groups = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		
		for (String s : strs) {
			char[] charArray = s.toCharArray();
			Arrays.parallelSort(charArray);
			String anagram = new String(charArray);
			
			if (map.containsKey(anagram)) {
				map.get(anagram).add(s);
			} else {
				ArrayList<String> anagramList = new ArrayList<String>();
				anagramList.add(s);
				map.put(anagram, anagramList);
			}
		}
		
		for(Entry<String, ArrayList<String>> e : map.entrySet()) {
			ArrayList<String> anagramList = e.getValue();
			groups.add(anagramList);
		}
		
//		return new ArrayList<List<String>>(dict.values());
        return groups;
    }
	

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(s));

	}

}
