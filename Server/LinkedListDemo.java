import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;
class LinkedListDemo
{
	static Scanner sc=new Scanner(System.in);
	static FileInputStream fin;
	static FileOutputStream fout;
	static ObjectInputStream in;
	static ObjectOutputStream Objout;
	static File file=new File("userLog.txt");
	static 	User head=null;
	
	static void accept()
	{
				
		out.print("Enter user name:");
		String u=sc.next();
		out.print("Password:");
		String p=sc.next();
		out.print("First name:");
		String f=sc.next();
		out.print("Last name:");
		String l=sc.next();
		out.print("Contact no:");
		long c=sc.nextLong();
		User newUser=new User(u,p,f,l,c);
		insert(newUser);	
	}
	
	public static void main(String args[]) throws Exception
	{
		int choice;
	
	
		do
		{
			out.println("1.Insert.");
			out.println("2.Delete");
			out.println("3.Update");
			out.println("4.Display.");
			out.println("5.Search.");
			out.println("6.Exit");
			out.println("7.Read File.");
			out.println("8.Write file.");
			out.print("Enter choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
				accept();
				out.print(head);
				break;		
				
				case 2:
				out.println("Enter userName to delete:");
				if(delete(sc.next()))
				out.println("Deleted");
				else
				out.println("Not found ");
				break;		
	
				case 3:
				
				
				break;		
	
	
				case 4:
				display(head);
				break;		
	
				case 5:
				break;	
				
				case 6:
				System.exit(0);
				break;		
			
				default:
				out.println("Invalid choice....");
				
				case 8:
				writeFile(head);
				break;
				
				case 7:
				readFile();
				break;
	
			}
		}while(choice!=6);
		
		
	}
			/*This method inserts the user data according to ascending order of user name.
	 *flag=true indicates user data succssfully inserted and 
	 *flag=false indicates user data with duplicate user name
	 **/
	static	boolean insert(User newUser)
		{
			User temp=null,prev=null;
			boolean flag=false;
			
			if(head==null)
			{
				head=newUser;			
				head.next=null;
				flag=true;
				
			}else if(head.userName.equals(newUser.userName))
						return false;
			 else  if(head.userName.compareTo(newUser.userName)>0)
				{
						newUser.next=head;
						head.next=null;
						head=newUser;
						flag=true;
				}else
					{
						
						temp=head;
						
						while((temp.userName.compareTo(newUser.userName)<=0))
						{
							if(temp.userName.equals(newUser.userName))
								return false;  //user name already exist in the list.
						
							if(temp.next==null)
							{
								temp.next=newUser;
								newUser.next=null;
								flag=true;
								return flag;							//insert in last
							}
							prev=temp;
							temp=temp.next;
						}
						
						prev.next=newUser;
						newUser.next=temp;	//insert in middle
						flag=true;
					}
		
		return flag;
		}

		
		
	static boolean delete(String un)
	{
		User temp,prev;
		boolean flag=false;
		if(head.userName.equals(un))
		{
				temp=head;
				head=head.next;	
				temp=null;
				flag=true;
		}else 
		 {
		 	prev=head;
		 	temp=head.next;
		 	
		 	while(temp!=null)
		 	{
		 	   if(temp.userName.compareTo(un)==0)
		 	   {
		 	   	flag=true;
		 	   	prev.next=temp.next;
		 	   }
		 	    prev=temp;
		 	   temp=temp.next;
		 	}
		 }
		
		return flag;
	}
	
	static void display(User h)
	{
		
		User temp=h;
		while(temp!=null)
		{
			out.println(temp);
			temp=temp.next;
		}
	
	}
	
	static void readFile() 
	{
			try
			{
			head=null;
		fin=new FileInputStream(file);
		in=new ObjectInputStream(fin);
		User temp;
		
		while((temp=(User)in.readObject())!=null)
		 {
		 	out.println(temp);
		 	insert(temp);
		 }
		 
		 in.close();
		 fin.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		static void writeFile(User h) throws Exception
		{
			fout=new FileOutputStream(file);
			Objout=new ObjectOutputStream(fout);
			User temp=h;
			while(temp!=null)
			{
				Objout.writeObject(temp);
				temp=temp.next;
			}			
		
		out.println("File written...");
		Objout.close();
		fout.close();
	
		}
	}