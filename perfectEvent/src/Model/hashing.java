package Model;
import java.util.*;

public class hashing {

	public static int getHash(String pwd,int salt)
	
	{
		
		int s=0;
		
		for (int j=0;j<=pwd.length()-1;j++)
		{
		char c1=pwd.charAt(j);
		int k=(int)c1;
		s=s+k;
		System.out.println(k);
		System.out.println("\n"+salt);
		}
	
	int h=(s*9*salt)-(18+salt);
	System.out.println("\n"+h);
	return h;
	}
}