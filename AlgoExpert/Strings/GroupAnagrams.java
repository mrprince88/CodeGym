 import java.util.*;

 class GroupAnagrams {

 	static void solve(List<String> list){

 		HashMap<String,List<String>> h=new HashMap<>();

 		for(String i: list){

 			char[] str=i.toCharArray();
 			Arrays.sort(str);
 			String entry=String.valueOf(str);

 			List<String> a=h.getOrDefault(entry,new ArrayList<>());
 			a.add(i);
 			h.put(entry,a);
 		}

 		int c=1;
 		for(String i: h.keySet()){
 			System.out.print("Group "+ c++ +": ");
 			System.out.println(h.get(i));
 		}

 	}
 
	public static void main(String[] args){
		List<String> list=Arrays.asList("go","flop","act","tac","cat","lopf");
		solve(list);
	}	
}