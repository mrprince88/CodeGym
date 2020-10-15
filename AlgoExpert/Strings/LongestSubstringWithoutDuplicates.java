 import java.util.HashMap;

 class LongestSubstringWithoutDuplicates {

 	static String solve(String s){
 		
 		HashMap<Character,Integer> h=new HashMap<>();

 		int[] res={0,1};
 		int startIndex=0,i=0;

 		while(i!=s.length()){

 			if(h.containsKey(s.charAt(i)) && startIndex<=h.get(s.charAt(i)))
 				startIndex=Math.max(startIndex,h.get(s.charAt(i))+1);

 			h.put(s.charAt(i),i);

 			if(res[1]-res[0]<i+1-startIndex)
 				res=new int[]{startIndex,i+1};

 			i++;
 		}

 		return s.substring(res[0],res[1]);
 	}
 
	public static void main(String[] args){
		String s="HelloWorldIAmYourFriend";
		System.out.println(solve(s));
	}	
}