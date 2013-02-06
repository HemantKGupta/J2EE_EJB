package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import java.sql.*;
import javax.ejb.*;
import java.util.Date;
import java.util.Calendar;
import javax.ejb.Timer;
public class TravelAgentBean implements TravelAgentRemote
{	
	 @Resource javax.ejb.TimerService timerService;

	
	public String sayHello(String name) {
		Calendar time = Calendar.getInstance( );  
		time.add(Calendar.MINUTE, 1); // add 30 days to the current time.
		Date date = time.getTime( );

		timerService.createTimer(date, null);
		//timerService.createTimer(1000 * 30, null);
		return "Hi, "+ name ; 
		
    }
	@Timeout
	public void aTime(Timer timer){
		System.out.println("Called by container");
	}
	
}
