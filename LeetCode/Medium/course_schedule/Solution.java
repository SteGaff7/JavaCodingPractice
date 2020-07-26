package course_schedule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		
//		if (prerequisites.length > numCourses) {
//			return false;
//		}
		
		
//		If cycle return false
		for (int[] coursePair : prerequisites) {
			Map<int[], Boolean> visited = new HashMap<int[], Boolean>();
			if (cycleRecur(coursePair, prerequisites, visited)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean cycleRecur(int[] currPair, int[][] prerequisites, Map<int[], Boolean> visited) {
		
		if (visited.getOrDefault(currPair, false)) {
			System.out.println(Arrays.toString(currPair));
			return true;
		}
		
		visited.put(currPair, true);

	
		for (int[] coursePair : prerequisites) {
			
			if (currPair[1] == coursePair[0]) {
				visited = new HashMap<int[], Boolean>();
				if (cycleRecur(coursePair, prerequisites, visited)) {
					return true;
				}
			}
			
		}
		
		return false;
	}


	public static void main(String[] args) {
//		int num = 3;
//		int[][] pre = {{1,0}, {2,0}, {0,2}};
		
//		int num = 2;
//		int[][] pre = {{1,0}};
		
//		int num = 3;
//		int[][] pre = {{1,0}, {2,1}};
		
//		
//		int num = 4;
//		int[][] pre = {{3,0},{0,1}};
		
//		int num = 4;
//		int[][] pre = {{1,0},{2,1}, {3,2}, {1,3}};
		
		int num = 7;
		int[][] pre = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};

		
		System.out.println(canFinish(num, pre));

	}

}
