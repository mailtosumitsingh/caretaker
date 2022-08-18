package org.rinky.digitalassistant.bot.main;

import static org.rinky.digitalassistant.bot.japyter.client.Shell.InspectDetailLevel.FINE;
import static org.rinky.digitalassistant.bot.japyter.gen.HistoryRequest.HistAccessType.TAIL;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.rinky.digitalassistant.bot.japyter.Japyter;
import org.rinky.digitalassistant.bot.japyter.client.Shell;
import org.rinky.digitalassistant.bot.japyter.client.IoPub.BroadcastListener;
import org.rinky.digitalassistant.bot.japyter.client.IoPub.MessageListener;
import org.rinky.digitalassistant.bot.japyter.client.Stdin.AbstractStdinHandler;
import org.rinky.digitalassistant.bot.japyter.client.Stdin.StdinHandler;
import org.rinky.digitalassistant.bot.japyter.gen.Broadcast;
import org.rinky.digitalassistant.bot.japyter.gen.ExecuteRequest;
import org.rinky.digitalassistant.bot.japyter.gen.HistoryRequest;
import org.rinky.digitalassistant.bot.japyter.gen.Message;

public class JapyterTest {
	
	public static void main(String[] args) throws IOException {
		
		   final StdinHandler randomStdinHandler = new AbstractStdinHandler()
	       {
	           @Override
	           public String prompt(final String text, final boolean password)
	           {
	               return RandomStringUtils.randomAlphanumeric(20);
	           }
	       };	
		try(Japyter japyter = Japyter.fromConfigFile(new File("C:\\projects\\caretaker\\bot\\connect.txt"))
	            .withUserName("it-test")
	            .withStdinHandler(randomStdinHandler)
	            .build())
		{

	       japyter.getIoPub().subscribe(new BroadcastListener()
	       {
	           @Override 
	           public void handle(final Broadcast b)
	           {
	               System.out.println("IoPub Broadcast: " + b);
	           }
	       });
	       japyter.getIoPub().subscribe(new MessageListener()
	       {
	           @Override
	           public void handle(final Message m)
	           {
	               System.out.println("IoPub Message: " + m);
	           }
	       });

	       System.out.println("Heartbeat state: {}\n"+ japyter.getHeartbeat().getState());

	       System.out.println("\n\nType ENTER to stop\n");

	       System.out.println("Heartbeat state: {}\n"+ japyter.getHeartbeat().getState());
	       System.out.println("\n\nStopping...");
	   	Shell shell = japyter.getShell();
		   System.out.println("ExecuteReply: " + shell.execute(new ExecuteRequest().withCode("3+7")));
		   System.out.println("ExecuteReply: " + shell.execute(new ExecuteRequest().withCode("iconify(\"c:\\\\temp\\\\IMG_6597.JPG\",\"c:\\\\temp\\\\icon3.jpg\",20,20)")));
		   
	    System.out.println("InspectReply: " + shell.inspect("123.", 4, FINE));
	    System.out.println("CompleteReply: " + shell.complete("123.", 4));
	    System.out.println("IsCompleteReply: " + shell.isComplete("123."));
	    System.out.println("HistoryReply: "
	                + shell.history(new HistoryRequest().withHistAccessType(TAIL).withN(10)));

	    System.out.println("\n\n*** CONTROL TESTS ***\n");
	    waitEnter();
	   }
	   finally
	   {
		   
	       System.exit(0);
	   }

	    
	}
	private static void waitEnter()
	{
	    try (Scanner s = new Scanner(System.in))
	    {
	        s.nextLine();
	    }
	}
}