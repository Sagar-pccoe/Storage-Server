import java.io.*;
class Database
{
	static FileInputStream fin;
	static FileOutputStream fout;
	static ObjectInputStream Objin;
	static ObjectOutputStream Objout;

	static File file=new File("RegisteredUser");
	
	private	static User head=null;

	static void init()
	{
		readFile();
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
		 	   if(temp.userName.equals(un))
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
	
	static User search(String userName,String pwd)
	{
		User temp=head;
		while(temp!=null && !(temp.userName.equals(userName)&&temp.password.equals(pwd)))
			temp=temp.next;
			
			return temp;
	}
	
	static User search(String userName)
	{
		User temp=head;
		while(temp!=null && !(temp.userName.equals(userName)))
			temp=temp.next;
			
			return temp;
	}
	
	static boolean update(User newUserData)
	{
		User temp=head;
		boolean flag=false;
		while(!temp.userName.equals(newUserData.userName)&&temp!=null) //search data sequentially
		temp=temp.next;
		
		if(temp!=null) //	if found
		{
			temp=new User(newUserData,temp.next);
			System.out.println("Updated data:"+temp);
			flag=true;
			display(head);	
		}
		return flag;
	}
	
	static void display(User h)
	{
		
		User temp=h;
		while(temp!=null)
		{
			System.out.println(temp);
			temp=temp.next;
		}
	
	}
	
	static void readFile() 
	{
		try
		{
		head=null;
		fin=new FileInputStream(file);
		Objin=new ObjectInputStream(fin);
		User temp;
		
		while((temp=(User)Objin.readObject())!=null)
		 {
		 	insert(temp);
		 }
		 
		 Objin.close();
		 fin.close();
		}catch(EOFException e)
		{
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		static void writeFile() throws Exception
		{
			fout=new FileOutputStream(file);
			Objout=new ObjectOutputStream(fout);
			User temp=head;
			while(temp!=null)
			{
				Objout.writeObject(temp);
				temp=temp.next;
			}			
		Objout.close();
		fout.close();
	
		}
		
		static void writeFile(boolean b)throws Exception
		{
			fout=new FileOutputStream(file);
			Objout=new ObjectOutputStream(fout);
			User temp=head;
			while(temp!=null)
			{
				temp.loggedIn=false;
				Objout.writeObject(temp);
				temp=temp.next;
			}			
		Objout.close();
		fout.close();	
			
		}
	}
