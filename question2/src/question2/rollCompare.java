package question2;

import java.util.Comparator;

public class rollCompare implements Comparator<user> {
	int asc;
	// if asc=1 then it is ascending , if its 2 then descending
	
	public rollCompare(int asc)
	{
		this.asc=asc;
	}
	int result;
	@Override
	public int compare(user o1, user o2) {
		
		if(o1.rollno>o2.rollno)
		{
			result= 1;
		}
		else if(o1.rollno<o2.rollno)
		{
			result= -1;
		}
		else
			result= 0;
		
		if(asc==2)
		{
			result*=-1;
		}
		
		return result;
	}

}
