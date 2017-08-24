package calcupackage;



import java.util.ArrayList;

public class Operationlist 
{
	private String string1;

	
	public Operationlist() {
		this("");
	}
	public Operationlist(String string1) {
		super();
		this.string1 = string1;
	}
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	@Override
	public String toString() {
		return "Calculatorlist [string1=" + string1 + "]";
	}
	public String[] solvewithoutParenthesis(ArrayList<String>[] mylist)
	{
		int end=mylist[0].size();
		double x=0,y=0,z=0;
		String[] result=new String[2];
		char[] operator={'+','-','*','/','%'};
		Operation calculator=new Operation();
		for(int j=4;j>-1;j--)
		{
			for(int ii=0;ii<end;ii++)
			{
				if((mylist[0].get(ii)).charAt(0)==operator[j])
				{
					x=(Double.parseDouble(mylist[0].get(ii-1)));
					if(mylist[1].get(ii-1).equals("-"))x*=-1;
					y=Double.parseDouble(mylist[0].get(ii+1));
					if(mylist[1].get(ii+1).equals("-"))y*=-1;
					calculator.setX(x);
					if(j==0)z=calculator.add(y);
					if(j==1) z=calculator.subtract(y);
					if(j==2) z=calculator.multiple(y);
					if(j==3) z=calculator.divide(y);
					if(j==4) z=calculator.Modulo(y);
					if(z<0) {mylist[1].set(ii-1, "-"); z*=-1;}
					mylist[0].set(ii-1, String.valueOf(z));
					mylist[0].remove(ii); mylist[1].remove(ii);
					mylist[0].remove(ii); mylist[1].remove(ii);
					end-=2;
					ii=-1;
				} // end if operator
			} //end for with one operand	
		} // end control all operand	
		result[0]=mylist[0].get(0);
		result[1]=mylist[1].get(0);
		return result;
	}
	public double solve(ArrayList<String>[] mylist)
	{
		ArrayList<String>[] list=new ArrayList[2];
		list[0]=new ArrayList<String>();
		list[1]=new ArrayList<String>();
		int i=0,start=0,end=0,j,endlist;
		String[] r=new String[2];
		String s;
		double result=0;
		
		endlist=mylist[0].size();

		for(j=0;j<endlist;j++)
		{
			s=mylist[0].get(j);
			if(s.equals("(")) start=j;
			if(s.equals(")"))
			{
				end=j;				
				list[0].clear();list[1].clear();
				for(i=start+1;i<end;i++)
				{
					list[0].add(mylist[0].get(i));list[1].add(mylist[1].get(i));
				}

				r=solvewithoutParenthesis(list);
					
				mylist[0].set(start,String.valueOf(r[0]));
				mylist[1].set(start,r[1]);
				for(i=start+1;i<end+1;i++)
				{
					mylist[0].remove(start+1);
					mylist[1].remove(start+1);
				}
				j=-1;
				endlist=mylist[0].size();
			} //******************** end if ) )
			if(mylist[0].size()==1 && r[0]!=null)
			{
				result=Double.valueOf(r[0]);
				if(r[1].equals("-"))result*=-1;
				return result;
			}

		} // ******  end for list	
		r=solvewithoutParenthesis(mylist);
		result=Double.valueOf(r[0]);
		if(r[1].equals("-"))result*=-1;
		return result;	
	}
	public ArrayList<String>[] stringtoarray() throws Exception// control (Parenthesis , point ) and convert to array list
	{
		String ss="";
		int chek=0,Parenthesis=0,i=0;
		char[] number={'0','1','2','3','4','5','6','7','8','9','.'};
		ArrayList<String>[] myarray=new ArrayList[2];
		 myarray[0]=new ArrayList<String>();
		 myarray[1]=new ArrayList<String>();
		for(i=0;i<string1.length();i++)
		{
			if(include(number, string1.charAt(i)))
			{
				while(include(number, string1.charAt(i)))
				{ 
					if(chek==1 && string1.charAt(i)=='.')throw new Exception("this sentenses is wrong on your character number : "+ (++i));
					if(chek==0 && string1.charAt(i)=='.') chek++;
					ss+=string1.charAt(i); 
					i++;
					if(i==string1.length()){ myarray[0].add(ss);myarray[1].add("+"); return myarray;}
				}
				chek=0;
				i--;
			}
			else 
			{
				if(string1.charAt(i)=='(') Parenthesis++;
				if(string1.charAt(i)==')'&& Parenthesis==0) throw new Exception("this sentenses is wrong on your character number : "+ (++i));
				if(string1.charAt(i)==')'&& Parenthesis!=0) Parenthesis--;				
				ss+=string1.charAt(i);
			}
			myarray[0].add(ss);myarray[1].add("+");
			ss="";
		}
		if(Parenthesis!=0) throw new Exception("this sentenses is wrong on your character number : "+ (++i));
		return myarray;
	}
	public boolean include(char[] s,char c)
	{
		for(char cc:s)
			if(c==cc)return true;
		return false;		
	}
	public void stringtrim() throws Exception//  sentenses  structure control 
	{
		int i=0;
		string1=string1.trim();
		String string2="";
		char[] operator={'+','-','*','/','%'};
		char[] number={'0','1','2','3','4','5','6','7','8','9'};
		for(i=0;i<string1.length();i++)
		{
			//*********************************************************************	
			if(string1.charAt(i)=='(' )
			{
				if(i==0) 
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if(include(operator,string1.charAt(i-1))||(string1.charAt(i-1))=='(')
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if(include(number,string1.charAt(i-1))||(string1.charAt(i-1))==')')
				{ 
					string2+='*'; 
					string2+=string1.charAt(i); 
					continue;
				}
				if((string1.charAt(i-1))=='.')
				{ 
					string2+='0'; 
					string2+='*';
					string2+=string1.charAt(i); 
					continue;
				}				
			}     // end  if it is (*** ( ***)
		    //*********************************************************************	
			if(string1.charAt(i)==')' )
			{
				if(i==0) 
				{ 
					throw new Exception("this sentenses is wrong on your character number : "+ (++i)); 
				}				
				if((string1.charAt(i-1))=='(')
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if(include(number,string1.charAt(i-1))||(string1.charAt(i-1))==')')
				{  
					string2+=string1.charAt(i); 
					continue;
				}
				if((string1.charAt(i-1))=='.')
				{ 
					string2+='0'; 
					string2+=string1.charAt(i); 
					continue;
				}				
			}     // end  if it is (*** ) ***)

			//*********************************************************************	
			if(include(operator, string1.charAt(i)))
			{		
				if(i==0 && (((string1.charAt(i))=='+')||((string1.charAt(i))=='-'))) 
				{ 
					string2+='0'; 
					string2+=string1.charAt(i); 
					continue;
				}	
				if(i==0) 
				{ 
					throw new Exception("this sentenses is wrong on your character number : "+ (++i)); 
				}	
				if((string1.charAt(i-1))=='(')
				{ 
					if(((string1.charAt(i))=='+')||((string1.charAt(i))=='-'))
					{
						string2+='0'; 
						string2+=string1.charAt(i); 
						continue;
					}
				}
				if(include(number, string1.charAt(i-1))||(string1.charAt(i-1))==')')
				{  
					string2+=string1.charAt(i); 
					continue;
				}
				if((string1.charAt(i-1))=='.')
				{ 
					string2+='0'; 
					string2+=string1.charAt(i); 
					continue;
				}				
			}     // end  if it is (*** +,-,*,/,% ***)
			//*********************************************************************	
			if(include(number, string1.charAt(i)))
			{ 
				if(i==0) 
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if((include(operator, string1.charAt(i-1)))||(string1.charAt(i-1)=='(')||
						(include(number, string1.charAt(i-1)))||(string1.charAt(i-1)=='.'))
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if((string1.charAt(i-1))==')')
				{ 
					string2+='*';
					string2+=string1.charAt(i); 
					continue;
				}			
			}     // end  if it is (*** number ***)
			//*********************************************************************	
			if(string1.charAt(i)=='.' )
			{
				if(i==0) 
				{ 
					string2+='0';
					string2+=string1.charAt(i); 
					continue;
				}
				if(include(operator, string1.charAt(i-1))||(string1.charAt(i-1))=='(')
				{ 
					string2+='0';
					string2+=string1.charAt(i); 
					continue;
				}
				if(include(number, string1.charAt(i-1)))
				{ 
					string2+=string1.charAt(i); 
					continue;
				}
				if((string1.charAt(i-1))==')')
				{ 
					string2+='*';
					string2+='0';
					string2+=string1.charAt(i); 
					continue;
				}			
			}     // end  if it is (*** . ***)
			throw new Exception("this sentenses is wrong on your character number : "+ (++i)); 
		}
		if(i<1)throw new Exception("this sentence is empty "); 
		if(include(operator, string1.charAt(i-1)))
			throw new Exception("this sentenses is wrong on your character number : "+ (i)); 
		string1=string2;
	}
	
}
