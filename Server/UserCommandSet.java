 interface UserCommandSet
{
	int REGISTER_USER=1;
	int LOGIN_USER=2;
	int UPDATE_USER=3;
	int UNREGISTER_USER=4;
	int SUCCESS=5;
	int FAILED=6;
	
	int CHANGE_PASSWORD=7;
	int FORGOT_PASSWORD=8;
	
	int DISCONNECT=100;
	
	int ALREADY_LOGGED_IN=11;
	int INVALID_USER_NAME=12;
	int INVALID_PASSWORD=13;
	
	int registerUser(User u) throws Exception;
	int loginUser(String userName,String pwd)throws Exception;
	int updateUser(User u)throws Exception;
	int unregisterUser(User u)throws Exception;
	void disconnectUser()throws Exception;
	
}

