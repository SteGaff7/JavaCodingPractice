package group_people_by_group_size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		int id = 0;
		
		for (int i : groupSizes) {
			
			List<Integer> group;
			
			if (map.containsKey(i)) {
				group = map.get(i);
			} else {
				group = new ArrayList<Integer>(i);
				map.put(i, group);
			}
			
			group.add(id);
			id++;
			
			if (group.size() == i) {
//				Append to groups and delete
				groups.add(group);
				map.remove(i);
			}
		}
		
		return groups;
	}
	
	public static void main(String args[]) {
		int[] groupSizes = {3,3,3,3,3,1,3};
		System.out.println(groupThePeople(groupSizes));
	}

}
