package calcupackage;

import java.util.ArrayList;

public class Operation 
{
	private static ArrayList<String> counter =new ArrayList<String>();
	private double x;
	
	

	public static ArrayList<String> getCounter() {
		return counter;
	}
	public static void setCounter(ArrayList<String> counter) {
		Operation.counter = counter;
	}
	public Operation() 
	{
		this(0);
	}
	public Operation(double x) 
	{
		super();
		this.x = x;
	}
	public double getX() 
	{
		return x;
	}
	public void setX(double x) 
	{
		this.x = x;
	}
	public double add(double y)
	{
		String s="";
		s=String.format("%-5s%-15.2f%-10s%-15.2f%-8s%-15.2f","( ",x,") + ( ", y,") = ",x+y);	
		counter.add(s);
		return x+y;
	}
	public double subtract(double y)
	{
		String s="";
		s=String.format("%-5s%-15.2f%-10s%-15.2f%-8s%-15.2f","( ",x,") - ( ", y,") = ",x-y);	
		counter.add(s);
		return x-y;
	}
	public double multiple(double y)
	{
		String s="";
		s=String.format("%-5s%-15.2f%-10s%-15.2f%-8s%-15.2f","( ",x,") * ( ", y,") = ",x*y);
		counter.add(s);
		return x*y;
	}
	public double divide(double y)
	{
		String s="";
		s=String.format("%-5s%-15.2f%-10s%-15.2f%-8s%-15.2f","( ",x,") / ( ", y,") = ",x/y);
		counter.add(s);
		return x/y;
	}
	public double Modulo(double y)
	{
		String s="";
		s=String.format("%-5s%-15.2f%-10s%-15.2f%-8s%-15.2f","( ",x,") % ( ", y,") = ",x%y);
		counter.add(s);
		return x%y;
	}
	@Override
	public String toString() {
		return "Calculator [x=" + x + "]";
	}
	
}
