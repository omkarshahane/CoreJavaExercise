package atmBank;

import java.util.HashMap;
import java.util.logging.Logger;

public class AtmMachine {
	
	public void Withdraw(AccountAtm a,double wd)
	{
		if(wd<a.bal)
		{
			if(a.bal-wd>500) {
		a.bal = a.bal-wd;
		System.out.println("Withdrawl Amount= "+wd);
		System.out.println("\nCurrent Balance= "+a.bal);
			}
			else
				System.err.println("Balance Cannot Be Less Than Rs.500");
		}
		else
		{
			System.out.println("Low balance");
		}
	}
	public void Deposite(AccountAtm a, double dp)
	{
		a.bal=a.bal+dp;
		System.out.println("Deposited Amount= "+dp);
		System.out.println("\nCurrent Balance= "+a.bal);
		
	}
	public void CheckBal(AccountAtm a)
	{
		System.out.println("Current Balance -- "+a.bal);
	}
	
	public void ChangePin(AccountAtm a, HashMap<Integer, Integer> pinMap, int pin)
	{
		pinMap.put(a.AccNo,pin);
		System.out.println("pin changed successfully");
	}

}
