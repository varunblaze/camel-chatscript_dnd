package org.apache.camel.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ChatScriptBotTest {

	 char nullChar = (char) 0;
	        String userName = "Jerry"; // or take as input
	 
	 public String processInput(String input) {
	  return doMessage("Varun"+nullChar+nullChar+input+nullChar);
	 }

	 private String doMessage(String mess)
	 {
	  Socket echoSocket;
	  String resp = "";
	  
	  try {
	   echoSocket = new Socket("localhost", 1024);
	   PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),
	     true);
	   BufferedReader in = new BufferedReader(new InputStreamReader(
	     echoSocket.getInputStream()));
	   out.println(mess);
	   resp = in.readLine();
	   echoSocket.close();
	  } catch (IOException e) {
	   e.printStackTrace();
	   System.out.println("Error: " + e.getMessage());
	  }

	  return resp;
	  
	 }
	 public void init(HashMap<String, String> args) {
	  System.out.println("ChatScript Bot init()...");
	  System.out.println("got back:" + doMessage(nullChar+"1"+nullChar+nullChar));
	  System.out.println("now starting conversation..." + doMessage(userName+nullChar+nullChar+nullChar));
	  System.out.println("conversation started with default bot as " + userName);
	 }

	 public String getBotType() {
	  // TODO Auto-generated method stub
	  return "ChatSCript";
	 }
public static void main(String[] arg)
{
	ChatScriptBotTest t= new ChatScriptBotTest();
	t.init(null);
	Scanner in=new Scanner(System.in);
	while (true)
	{
		String input=	in.nextLine();
		System.out.println(t.processInput (input));
	}
} 
}