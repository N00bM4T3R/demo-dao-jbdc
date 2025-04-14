package db;

public class DbIntegritExcepition extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public DbIntegritExcepition(String msg) {
		super(msg);
	}
	
}
