import java.io.File;
interface FileCommandSet
{
	int CREATE_FILE=21;
	int DELETE_FILE=22;
	
	int CREATE_DIR=23;
	int DELETE_DIR=24;
	
	int SEND=25;
	int RECEIVE=26;
	
	int SEND_LIST=27;
	int RECEIVE_LIST=28;
	
	int CHANGE_DIR=29;
	int REFRESH=30;
	int HOME=31;
	
	int createFile(File f)throws Exception;
	int deleteFile(File f)throws Exception;
	
	int createDirectory(File f);
	int deleteDirectory(File f);
	
	int sendFile(File f)throws Exception;
	int receiveFile(File f)throws Exception; 
	
	void sendList(Path p) throws Exception;
	Path receiveList() throws Exception;
	
	Path changeDirectory(String f) throws Exception;
}

