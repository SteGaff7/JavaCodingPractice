package all_paths_source_to_target;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * @author stephen
 *
 */

public class Solution {

		public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
			
			int startIdx = 0;
			int endIdx = graph.length - 1;
			
			List<List<Integer>> paths = new ArrayList<List<Integer>>();
			
//			Recur down each path from start index
			ArrayList<Integer> path = new ArrayList<Integer>();
			recur(graph, startIdx, endIdx, path, paths);
			
			return paths;
    }
		
		public static void recur(int[][] graph, int currIdx, int endIdx, List<Integer> currPath, List<List<Integer>> paths) {
//			Add current node to path
			currPath.add(currIdx);
			
			if (currIdx == endIdx) {
//				Valid path, append to valid paths
				paths.add(currPath);
				return;
			}
			
			for (int i = 0; i < graph[currIdx].length; i++) {
				List<Integer> copyList = new ArrayList<Integer>(currPath);
				recur(graph, graph[currIdx][i], endIdx, copyList, paths);
			}
		}

	public static void main(String[] args) {
		int[][] graph = {{1, 2}, {3}, {3}, {}};
		System.out.println(allPathsSourceTarget(graph));

	}

}
