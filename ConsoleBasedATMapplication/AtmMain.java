package atmBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class AtmMain {

	public static void main(String[] args) 
	{
		ArrayList<AccountAtm> acList=new ArrayList<AccountAtm>();
		
		acList.add(new AccountAtm(11,"Rushi","N",22000.00,1000));
		acList.add(new AccountAtm(12,"Siddharth","B",27000.00,1001));
		acList.add(new AccountAtm(13,"Pratik","J",29900.00,1002));
		acList.add(new AccountAtm(14,"Arnabh","H",31000.00,1003));
		acList.add(new AccountAtm(15,"Jit","M",32090.00,1004));
		acList.add(new AccountAtm(16,"Geeta","A",23500.00,1005));
		acList.add(new AccountAtm(17,"Sita","B",56530.00,1006));
		acList.add(new AccountAtm(18,"Reeta","D",45670.00,1007));
		acList.add(new AccountAtm(19,"Om","E",64320.00,1008));
		acList.add(new AccountAtm(20,"Mit","F",245000.00,1009));
		
		//AccountAtm.accDisplay(Ac);
		
		HashMap<Integer, Integer> pinMap = new HashMap<Integer, Integer>();
		
		pinMap.put(11, 1001);
		pinMap.put(12, 1002);
		pinMap.put(13, 1003);
		pinMap.put(14, 1004);
		pinMap.put(15, 1005);
		pinMap.put(16, 1006);
		pinMap.put(17, 1007);
		pinMap.put(18, 1008);
		pinMap.put(19, 1009);
		pinMap.put(20, 1000);
		
		
		Scanner sc =new Scanner(System.in);
		//System.out.println("Please enter # to continue and any key to exit");
		while(true)  //(sc.next().equals("#")) 
		{		
		System.out.println("Enter account no and pin ");
		int acno, pin;
		acno=sc.nextInt(); 
		pin=sc.nextInt();
		
		if(pinMap.get(acno) != null && pinMap.get(acno) == pin )
		{
			AccountAtm loggedinAccount=null;
			Iterator<AccountAtm> it = acList.iterator();
			while(it.hasNext()) 
			{
				AccountAtm nextAccount = it.next();
				if(acno == nextAccount.AccNo) 
				{
					loggedinAccount = nextAccount;
					break;
				}
			}
			System.out.println("1.Withdraw \n2.Deposite \n3.Check Balance\n4.Pin Change ");
			
			int ch=sc.nextInt();
			
			AtmMachine atm = new AtmMachine();
			switch(ch)
			{
			case 1:
				System.out.println("enter amount for withdrawl");
				atm.Withdraw(loggedinAccount, sc.nextDouble());
				break;
			case 2:
				System.out.println("Enter Amount For Credit");
				atm.Deposite(loggedinAccount, sc.nextDouble());
				break;
			case 3:
				atm.CheckBal(loggedinAccount);
				break;
			case 4:
				System.out.println("enter new pin: ");
				//pinMap.put(loggedinAccount.AccNo,sc.nextInt());
				
				atm.ChangePin(loggedinAccount, pinMap, sc.nextInt());
				break;
			default:
				System.out.println("Wrong choice");
			}	
		}
		if( acno==9999 && pin==1233)
		{
			System.out.println("Welcome Admin\n\n\n Enter admin password: ");
			
			if(sc.nextInt()==9090)
			{
				System.out.println("\nEnter Account Number: ");
				int accNo=sc.nextInt();
				System.out.println("\nEnter First Name of Account Holder: ");
				String fName=sc.next();
				System.out.println("\nEnter Last Name of Account Holder: ");
				String lName=sc.next();
				System.out.println("\nEnter Balance: ");
				double bal=sc.nextDouble();
				System.out.println("\nEnter PIN for this Account : ");
				int pinSet=sc.nextInt();
				AccountAtm.addAccount(acList, pinMap, accNo, fName, lName, bal, pinSet);
			}
			
		}
		//System.out.println("Please enter # to continue and any key to exit");
		}
	}
}







