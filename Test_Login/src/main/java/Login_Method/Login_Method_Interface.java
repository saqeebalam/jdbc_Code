package Login_Method;

public interface Login_Method_Interface {

	public void createConnectionDB(String email,String password);
	public boolean verifyLoginId(String email,String password);
	public int updateDataDB(String name,String city,String mobile,String email);
	public void closeDB();
}
