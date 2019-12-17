package question2;

import java.util.Comparator;

public class nameCompare implements Comparator<user>{
	
	int asc;
	// if asc=1 then it is ascending , if its 2 then descending
	
	public nameCompare(int asc)
	{
		this.asc=asc;
	}
	int result;
	@Override
	public int compare(user o1, user o2) {
		
		if(o1.name.compareTo(o2.name)>0)
		{
			result= 1;
		}
		else if(o1.name.compareTo(o2.name)<0)
		{
			result= -1;
		}
		else
		{
			
			return o1.rollno - o2.rollno;
		}
		
		if(asc==2)
		{
			result*=-1;
		}
		
		return result;
	}

}
