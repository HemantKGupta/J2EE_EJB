package examples.stateless;

import javax.ejb.ApplicationException;

@ApplicationException
public class MyException extends Exception{
	
	MyException(){
		
	}
	MyException(String s){
		super(s);
	}
}