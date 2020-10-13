package aayoos;
import java.io.*;
import java.io.InputStreamReader;
import java.util.*;
public class chatbot {
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		s=br.readLine();
		int i,l=s.length();
		char ch;
		int max[]= {0,0};
		int odd[]= {0,0};
		int even[]= {0,0};
		for(i=1;i<l-1;i++)
		{
			odd=ispallindrome(i-1,i+1,s);
			even=ispallindrome(i-1,i,s);
			if((odd[1]-odd[0])>(max[1]-max[0]))
			{
				max[1]=odd[1];
				max[0]=odd[0];
			}
			if((even[1]-even[0])>(max[1]-max[0]))
			{
				max[1]=even[1];
				max[0]=even[0];
			}
		}
		System.out.println(s.substring(max[0],max[1]+1));
}
	public static int[] ispallindrome(int leftidx, int ritidx,String s)
	{
		int odd[]=new int[2];
		while(s.charAt(leftidx)==s.charAt(ritidx)&&leftidx>0&&ritidx<s.length())
		{
			--leftidx;
			++ritidx;
		}
		odd[0]=leftidx+1;
		odd[1]=ritidx-1;
		return odd;
	}
}