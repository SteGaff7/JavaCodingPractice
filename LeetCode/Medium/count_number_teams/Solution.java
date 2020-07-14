package count_number_teams;

import java.util.Stack;

/**
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * @author stephen
 *
 */
public class Solution {
	
	public static int numTeams(int[] rating) {
        int numTeams = 0;
        
        for (int i = 0; i < rating.length; i++) {
        	int current = rating[i];
        	
        	for (int j = 0; j < rating.length; j++) {
        		if (i == j) {
        			continue;
        		}
        		
        		
        	}
        }
        
        
        
        return numTeams;
    }

	public static void main(String[] args) {
		int[] rating = {2,5,3,4,1};
		
		System.out.println(numTeams(rating));

	}

}
