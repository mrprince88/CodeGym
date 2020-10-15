 import java.util.*;

 class UnderscorifySubstring {

 	static String solve(String str,String subString){
 		List<int[]> isPresent=find(str,subString);
 		List<int[]> flattenedList=flattenList(isPresent);

 		return Underscorify(str,flattenedList);
 	}

 	static List<int[]> find(String str1,String str2){
 		List<int[]> list=new ArrayList<>();
 		int i=0;

 		while(i<str1.length()){
 			int lastIndex=str1.indexOf(str2,i);
 			if(lastIndex!=-1)
 				list.add(new int[]{lastIndex,lastIndex+str2.length()});
 			else
 				break;
 			i++;
 		}
 		return list;
 	}

 	static List<int[]> flattenList(List<int[]> list){

 		if(list.isEmpty())
 			return list;

 		List<int[]> flattenedList=new ArrayList<>();
 		flattenedList.add(list.get(0));
 		int[] previous = flattenedList.get(0);

		for (int i = 1; i < list.size(); i++) {
			int[] current = list.get(i);

			if(previous[1]>=current[0])
				previous[1]=current[1];

			else{
				flattenedList.add(current);
				previous=current;
			}

		}
		return flattenedList;
 	}

 	static String Underscorify(String str,List<int[]> list){
 		StringBuffer sb=new StringBuffer();
 		sb.append(str);
 		int c=0;
 		for(int i=0;i<list.size();i++){
 			int []pos=list.get(i);
 			sb.insert(pos[0]+c++,"_");
 			sb.insert(pos[1]+c++,"_");
 		}
 		return sb.toString();
 	}
 
	public static void main(String[] args){
		String str="testthis is a testtest to see if testestest it works";
		String subString="test";
		System.out.println(solve(str,subString));
	}	
}

/*
Output: _test_this is a _testtest_ to see if _testestest_ it works
*/