/*
 * Can the end of an array be reached?
 * Given an int array arr, return true if you can reach the last element 
 * or past the last element. 
 * Rules:
 * 1) Always start with the first element in the array.
 * 2) The elements value gives you the range of steps you can take. eg) if index[0] = 3 then you can take 1, 2, or 3 steps forward.
 * 3) If index[i]=0 then you cannot move forward if you are at this element.
 * 
 * Examples:
 * 1) arr = {1,3,1,0,0} should return true because at i=0 arr[i]=1 -> move 1 step-> arr[i] = 3 ->Can move 1, 2, or 3 steps.
 *  At 1 and 2 steps we hit a dead end so take the third and reach end. Return true
 *  
 *  2) arr =  {1,0,0} Returns False. There is no way to reach or cross the last element.
 */



public class Interview {
	public static boolean reachEnd(int curr, int[] arr) {
		if(arr.length-curr==1 || arr.length-curr==0|| curr>=arr.length) {
			return true;
		}
		else if(arr[curr]==0) {
			return false;
		}
		else {
			for(int i =1; i<=arr[curr]; i++) {
				if(!reachEnd(curr+i, arr)) {
					continue;
				}
				else{
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String args[]) {
		int[] arr = {1,2,0};
		if(reachEnd(0, arr)) {
			System.out.println(true);
		}else{
			System.out.println(false);
		};
	}
}
