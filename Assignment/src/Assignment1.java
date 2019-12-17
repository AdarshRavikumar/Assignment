
import java.util.*;

public class Assignment1 {

	String name,type;
	int quant;
	float price;
	
	
	public void Assign(q1 obj[],String args[],int obj_count)
	{
		 // In Args , the even places are -name, -type , -price etc... These become key for the hashmap and odd places are the actual names, price,etc
		 
	
		int flag=0;
		
		Map<String, String> hm = new HashMap<String, String>();
		
		for(int k=0;k<args.length;k+=2)
			hm.put(args[k],args[k+1]);
		
		
		name = hm.get("-name");
		
		if(hm.get("-price")==null)
			price=0;
		else 
			price = Float.parseFloat(hm.get("-price"));
		
		
		if(hm.get("-type")==null)
		{
			System.out.println("Type of object missing ");
			flag=1;
		}
		else if (hm.get("-type").equals("raw") || hm.get("-type").equals("manufactured") || hm.get("-type").equals("imported"))
			type = hm.get("-type");
		else
			System.out.println("The Type of material Doesnt Exist . it should be one of [raw, manufactured, imported]");
		
		
		if(hm.get("-quant")==null)
			quant=0;
		else
			quant = Integer.parseInt(hm.get("-quant"));
		 
		
		if(flag==0)
		obj[obj_count++]=new q1(name,quant,price, type);
		
	 }

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter -name<Item Name> -price<Item Price> -quant<Item Quantity> -type<Item type> ");
		int obj_count=0;
		
		q1 obj[] = new q1[100];
		
		Assignment1 asn = new Assignment1();
		 asn.Assign(obj, args, obj_count++);
		
		
		Scanner sc = new Scanner(System.in);
		String ch;	
		
		
		while(true)
		{
			System.out.println("You want to continue ? Y or N");
			
			ch= sc.nextLine();
			if(ch.equals("N") || ch.equals("n"))
			{
				break;
			}
			System.out.println("Enter Following Details Name, Price(The value should be in decimal ex: 100.0 or 123.4 etc), Quant, type[raw,manufactured,imported]");
			String inp = sc.nextLine();
			String arr[]=inp.split(" ");
			
			asn.Assign(obj, arr, obj_count++);
			
			
	    }
		
		// Printing objects
		
		for(int j=0;j<obj_count;j++)
		{
			if(obj[j]!=null)
				System.out.println(obj[j]);
		}
		
		

	}

}


