package atmBank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AccountAtm {
	protected int AccNo;
	protected String Fname;
	protected String Lname;
	protected double bal;
	protected int pin;

	
	public AccountAtm(int AccNo,String Fname,String Lname,double bal,int pin)
	{
		this.AccNo=AccNo;
		this.Fname=Fname;
		this.Lname=Lname;
		this.bal=bal;
		this.pin=pin;
		
	}
	@Override
	public String toString() {
		
		return "Acc: "+AccNo+" "+Fname+" "+Lname+" "+bal;
	}
	
	
	
	/*public static void accDisplay(ArrayList a)
	{
		Iterator i=a.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
			
		}
		
	}*/
	
	public static void addAccount(ArrayList<AccountAtm> acList,HashMap<Integer, Integer> pinMap,int accNo,String fName,String lName,double bal,int pin)
	{
		acList.add(new AccountAtm(accNo,fName,lName,bal,pin));
		pinMap.put(accNo, pin);
		
		try {
			File f = new File("MyAccount.txt");
			String data= accNo+" "+fName+" " + lName+" " +bal+" " +pin;
			
			FileOutputStream fos = new FileOutputStream(f,true);
			
			fos.write(data.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Account added successfully");
	}

}
