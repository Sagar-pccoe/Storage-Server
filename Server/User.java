
class User implements java.io.Serializable
{
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	long contactNo;
	String ip_hostName;
	String seqAns;
	boolean loggedIn;
	User next=null;
	
	User()
	{
		userName=null;
		password=null;
		firstName=null;
		lastName=null;
		email=null;
		contactNo=-1;
		ip_hostName=null;
		seqAns=null;		
		loggedIn=false;
	}
	
	User(String user,String pw,String fn,String ln,String e,long cn,String ans,String ip)
	{
		userName=user;
		password=pw;
		firstName=fn;
		lastName=ln;
		email=e;
		contactNo=cn;
		ip_hostName=ip;
		seqAns=ans;
		loggedIn=false;
	}
	
	User(String user,String pw,String fn,String ln,String e,long cn,String ans,String ip,boolean login)
	{
		userName=user;
		password=pw;
		firstName=fn;
		lastName=ln;
		email=e;
		contactNo=cn;
		ip_hostName=ip;
		seqAns=ans;
		loggedIn=login;
	}
	
	User(User u)
	{
		userName=u.userName;
		password=u.password;
		firstName=u.firstName;
		lastName=u.lastName;
		email=u.email;
		contactNo=u.contactNo;
		ip_hostName=u.ip_hostName;
		seqAns=u.seqAns;
		loggedIn=u.loggedIn;
        
	}
	
		User(User u,User link)
	{
		userName=u.userName;
		password=u.password;
		firstName=u.firstName;
		lastName=u.lastName;
		email=u.email;
		contactNo=u.contactNo;
		ip_hostName=u.ip_hostName;
		seqAns=u.seqAns;
		loggedIn=u.loggedIn;
		u.next=link.next;
        
	}
	
	User(String userName,String password)
	{
		this.userName=userName;
		this.password=password;
		firstName=null;
		lastName=null;
		email=null;
		contactNo=-1;
		ip_hostName=null;
		seqAns=null;		
		loggedIn=false;
	}
	
 public String toString()
 {
 	return userName+"\t"+password+"\t"+firstName+"\t"+lastName+"\t"+email+"\t\t"+contactNo+"\t\t"+seqAns+"\t\t"+ip_hostName+"\t\t"+loggedIn;
 } 
	
void setLoggedIn(boolean b)
{
	loggedIn=b;
}	
}