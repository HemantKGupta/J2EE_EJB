package examples.stateless;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class MyException extends RuntimeException{
	
	MyException(){
		
	}
	MyException(String s){
		super(s);
	}
}