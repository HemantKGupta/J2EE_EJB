package examples.stateless;

import javax.ejb.ApplicationException;

@ApplicationException
public class MyException extends RuntimeException{
	
	MyException(){
		
	}
	MyException(String s){
		super(s);
	}
}