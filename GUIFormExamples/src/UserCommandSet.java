 interface UserCommandSet
{
	int REGISTER_USER=1;
	int LOGIN_USER=2;
	int UPDATE_USER=3;
	int UNREGISTER_USER=4;
	int SUCCESS=5;
	int FAILED=6;
	int DISCONNECT=100;
	
        int ALREADY_LOGGED_IN=11;
        
	int registerUser(User u) throws Exception;
	int loginUser(User u)throws Exception;
	int updateUser(User u)throws Exception;
	int unregisterUser(User u)throws Exception;
        void disconnectUser()throws Exception;
	
}

