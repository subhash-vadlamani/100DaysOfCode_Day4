
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
	    InputStreamReader in = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(in);
	    
	    int testCases = Integer.parseInt(br.readLine());
	    int size;
	    
	    for(int i=0;i<testCases;i++)
	    {
	        size = Integer.parseInt(br.readLine());
	        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine());
	        int[] arr = new int[size];
	        int j=0;
	        while(tokenizer1.hasMoreTokens())
	        {
	            arr[j] = Integer.parseInt(tokenizer1.nextToken());
	            j++;
	        }
	        
	        int ans = kadane(arr,size);
	        System.out.println(ans);
	    }
	}
	
	public static int kadane(int[] arr, int size)
	{
	    int max_so_far = 0;
	    int max_ending_here = 0;
	    int count = 0;
	    
	    for(int i=0;i<size;i++)
	    {
	        if(arr[i]>0)
	        {
	            count++;
	        }
	        max_ending_here += arr[i];
	        
	        if(max_ending_here <0)
	        {
	            max_ending_here = 0;
	        }
	        if(max_so_far < max_ending_here)
	        {
	            max_so_far = max_ending_here;
	        }
	    }
	    
	    if(count == 0)
	    {
	        max_so_far = maxElement(arr,size);
	    }
	    
	    return max_so_far;
	    
	}
	
	public static int maxElement(int[] arr, int size)
	{
	    int max = arr[0];
	    for(int i=1;i<size;i++)
	    {
	        if(arr[i]>max)
	        {
	            max = arr[i];
	        }
	    }
	    return max;
	}
}