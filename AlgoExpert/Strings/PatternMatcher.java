import java.util.*;

 class PatternMatcher {

 	static List patternMatch(String str,String pattern){

 		if(pattern.length()>str.length())
 			return new ArrayList();

 		String newPattern=getNewPattern(pattern);
 		HashMap<Character,Integer> count=new HashMap<>();
 	    countXsAndYs(pattern,count);

 	    if(count.containsKey('y')) {

 	    int firstYIdx=pattern.indexOf('y');

 		for(int lenX=1;lenX<str.length();lenX++){

 			double lenY=(str.length()-lenX*count.get('x'))/count.get('y');

 			if(lenY < 0)
 				continue;

 			int yIdx=firstYIdx*lenX;
 			String x=str.substring(0,lenX);
 			String y=str.substring(yIdx,yIdx+(int)lenY);
 			String potentialMatch=getString(x,y,newPattern);
 			if(potentialMatch.equals(str))
 				return newPattern.equals(pattern) ? Arrays.asList(x,y):Arrays.asList(y,x);

 		}

 	}

 	else{
 		double lenX=str.length()/count.get('x');

 		if(lenX>0){
 			String x=str.substring(0,(int)lenX);
 			String potentialMatch=getString(x,"",pattern);
 			if(potentialMatch.equals(str))
 				return newPattern.equals(pattern) ? Arrays.asList(x,""):Arrays.asList("",x);
 			}
 		}

 		return new ArrayList();
 	}

 	static String getString(String x,String y,String pattern){
 		StringBuffer sb=new StringBuffer();
 		for(int i=0;i<pattern.length();i++){
 			if(pattern.charAt(i)=='x')
 				sb.append(x);
 			else
 				sb.append(y);
 		}
 		return sb.toString();
 	}

 	static String getNewPattern(String pattern){

 		if(pattern.charAt(0)=='x')
 			return pattern;

 		else{
 			StringBuffer sb=new StringBuffer();
 			for(int i=0;i<pattern.length();i++){
 				if(pattern.charAt(i)=='x')
 					sb.append('y');
 				else
 					sb.append('x');
 			}
 			return sb.toString();
 		}		
 	}

 	static void countXsAndYs(String pattern,HashMap<Character,Integer> count){

 		for(int i=0;i<pattern.length();i++){
 			int c=count.getOrDefault(pattern.charAt(i),0);
 			c++;
 			count.put(pattern.charAt(i),c);
 		}	
 	}
 
	public static void main(String[] args){
		String str="gogopowerrangergogopowerranger";
		String pattern="xxyxxy";
		System.out.println(patternMatch(str,pattern));
	}	
}

/*
OUTPUT:
[go, powerranger]
*/