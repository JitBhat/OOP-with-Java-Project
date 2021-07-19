package AccomodationManagement;
import java.util.*;				// importing all interfaces and classes from java.util package

interface services		
{
	void foodorder();
}

class weaver extends Thread
{
	public void run(int bill, String CustomerName)
	{
		System.out.println("Your Total Bill is :- Rs."+bill+ "\nThank You For Your Visit "+CustomerName+"\nVisit again!!");
	}
}

class Accomodation implements services
{
	int MinCost;
	protected int days;						//Access Specifier is protected here
	public int totalcost;
	Accomodation()
	{
		MinCost=500;
		days= 1;
		totalcost=MinCost;
	}
	
	Accomodation(int days)			// Overloading the Constructor
	{
		this.MinCost=500;
		this.days=days;
		totalcost= MinCost * days;
	}
	
	
	public void foodorder()
	{
		
		String foods[] ={"Idli","Masala Dosa","Roti","Kulcha","Curd Rice","Ghee Rice","Paneer Butter Masala","Khaju Curry","Mancho Soup"};
		int cost[]= {50,75,50,60,100,120,75,90,50};
		System.out.println("The Available foods are :-\n\nFood   Price\n");
		for(int i=0;i<cost.length;i++)
		{
			System.out.println(foods[i]+" - "+cost[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("What food would you like to order?");
		String order= sc.nextLine();
		
		int c=0;
		for(int i=0;i<cost.length;i++)
		{
			if(order.equalsIgnoreCase(foods[i]))			// string handling function
			{
				c=cost[i];
			}
		}
		totalcost= totalcost+ c;
		System.out.println("You Ordered "+order+" Thank You for ordering!!\n");
		
		
	}
}
	

class PentHouse extends Accomodation
{
	int availability[]=new int[10];
	int pentcost=1500;
	int room=-1;
	PentHouse(int days)
	{
		super(days);
		totalcost=totalcost+pentcost*days;
		for(int i=0;i<10;i++)
		{
			if(availability[i]==0)
			{
				room=i;
				availability[i]=1;
				break;
			}
		}
		if(room==-1)
		{
			System.out.println("Sorry, every Penthouses are booked");
		}
		System.out.println("Thank You For Booking.\n"+"PentHouse number "+(room+101)+" is assigned for you");
	}
	
	public void BodyMassage()
	{	int massagecost=250;
		System.out.println("Enjoy your Body Massage Service");
		totalcost= totalcost+massagecost;
	}
	
	public void WiFi()
	{
		int wificost=100;
		System.out.println("Enjoy the Wi-Fi Service");
		totalcost=totalcost+wificost*days;
	}
}


class ACRooms extends Accomodation
{
	int availabitiy[]=new int[10];
	int accost=500;
	int room;
	ACRooms(int days)
	{
		super(days);
		
		totalcost=totalcost+accost*days;
		for(int i=0;i<10;i++)
		{
			if(availabitiy[i]==0)
			{
				room=i;
				availabitiy[i]=1;
				break;
			}
		}
		if(room==-1)
		{
			System.out.println("Sorry, every AC Rooms are booked");
		}
		System.out.println("Thank You For Booking.\n"+"Room number "+(room+201)+" is assigned for you");
	
		
	}
	
	public void WiFi()
	{
		int wificost=100;
		System.out.println("Enjoy the Wi-Fi Service");
		totalcost=totalcost+wificost*days;
	}
	
}

class Cottages extends Accomodation
{
	int availabitiy[]=new int[10];
	int cotcost=100;
	int room;
	Cottages(int days)
	{
		super(days);
		
		totalcost=totalcost+cotcost*days;
		for(int i=0;i<10;i++)
		{
			if(availabitiy[i]==0)
			{
				room=i;
				availabitiy[i]=1;
				break;
			}
		}
		if(room==-1)
		{
			System.out.println("Sorry, every Cottages are booked");
		}
		System.out.println("Thank You For Booking.\n"+"Cottage number "+(room+301)+" is assigned for you");
	}
	
	public void foodorder()													// OverRiding the foodorder() function of superclass
	{
		
		String foods[] ={"Idli","Dosa","Roti","Curd Rice","Paneer Butter Masala"};
		int cost[]= {40,50,40,60,50};
		System.out.println("The Available foods are :-\n\nFood   Price\n");
		for(int i=0;i<cost.length;i++)
		{
			System.out.println(foods[i]+" - "+cost[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("What food would you like to order?");
		String order= sc.nextLine();
		
		int c=0;
		for(int i=0;i<cost.length;i++)
		{
			if(order.equalsIgnoreCase(foods[i]))
			{
				c=cost[i];
			}
		}
		totalcost= totalcost+ c;
		System.out.println("You Ordered "+order+" Thank You for ordering!!\n");
}
}

public class AccommodationSystem {
	
	public static void main(String args[])
	{
		int age,days;
		boolean custno=true;String CustomerName;
		Scanner sc =new Scanner(System.in);
		do {
			CustomerName=null;
			System.out.println("WELCOME TO VAIBHOGA PARADISE!! ");
			System.out.println("Enter your name:");
			CustomerName = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter your age:");
			age=sc.nextInt();
			sc.nextLine();
			if(age<18)
			{
				System.out.println("Bring your parents next time.");
				System.exit(0);
			}
			System.out.print("Enter number of days you want to stay\n");
			days=sc.nextInt();
			int bill=0;
			Accomodation ac=null;
			if(days >1) {
			ac =new Accomodation(days);
			}
			else if(days==1)
			{
				ac = new Accomodation();
			}
			else
			{	
				System.out.println("Wrong input, Try again from beginning");
				System.exit(0);
			}
			
			System.out.println("Select the accommodation facility you want\n1) Pent-House - Rs.2000 per day\n2) AC Rooms - Rs.1000 per day\n3) Cottages - Rs.600 per day");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: PentHouse ph=new PentHouse(days);
					int service=99;
					while(service!=0)
					{
						System.out.println("Services Available for you are:-\n1) Foods\n2) Wi-Fi - Rs.100 per day\n3) Body Massage - Rs.250 per Massage\n\nChoose corresponding number to order, or Enter 0 if you don't want any");
						service = sc.nextInt();
						switch(service)
						{	
						case 0: System.out.println("Thank You "+CustomerName+". Enjoy your stay!!");break;
						case 1: ph.foodorder();
								break;
						case 2: ph.WiFi();
								break;
						case 3: ph.BodyMassage();
								break;
						default: System.out.println("Choose the proper option");	
						}
						bill=ph.totalcost;
					}
					break;
			case 2: ACRooms acr = new ACRooms(days);
					int service2=99;
					while(service2!=0)
					{
						System.out.println("Services Available for you are:-\n1) Foods\n2) Wi-Fi - Rs.100 per day\n\nChoose corresponding number to order, or Enter 0 if you don't want any");
						service2 = sc.nextInt();
						switch(service2)
						{	
						case 0: System.out.println("Thank You "+CustomerName+". Enjoy your stay!!");break;
						case 1: acr.foodorder();
								break;
						case 2: acr.WiFi();
								break;
						default: System.out.println("Choose the proper option");	
						}
						bill=acr.totalcost;
					}
					break;
			case 3: Cottages cot = new Cottages(days);
					int service3=99;
					while(service3!=0)
					{
						System.out.println("Services Available for you are:-\n1) Foods\n\nChoose corresponding number to order, or Enter 0 if you don't want any");
						service3 = sc.nextInt();
						switch(service3)
						{	
						case 0: System.out.println("Thank You "+CustomerName+". Enjoy your stay!!");break;
						case 1: cot.foodorder();
								break;
						default: System.out.println("Choose the proper option");	
						}
						bill=cot.totalcost;
					}
					break;
			default: System.out.println("Select the Proper Choice");		
			}
			try {
				System.out.println("Waiting for Customer's Stay to End ");
				for(int i=1;i<=days;i++)
				{
					System.out.println("Day "+i); 		// Here 1 day = 1 second
					Thread.sleep(1000*days);			
				}
			}
			catch(InterruptedException e)			// Exception Handling
			{
				System.out.println("Stay Interrupted\nSorry for inconvinience "+ CustomerName);
			}
			
			weaver billgenerator = new weaver();
			billgenerator.run(bill, CustomerName);			// Thread Creation for Bill Generation
			
			System.out.println("Do we have next customer?\nPress 1 to say Yes any other number to say No");
			int cust=sc.nextInt();
			if(cust!=1)
			{
				custno=false;
			}
			else
			{
				custno=true;
			}
		}while(custno==true);
		}
}
