package com.codecool.util;
import java.util.*;
public class LogIn{

	private String group="";

	private FileParser fileWorkers;
	private FileParser fileStudents;
	
	private List<String[]> listOfAllHumans;
	public LogIn(){
	
		this.listOfAllHumans = new ArrayList<>();
		
	}
	
	public String FindGroupByLogin(String nick, String password){
		this.fileWorkers=new FileParser("Workers");
		this.fileStudents= new FileParser("STUDENTS FILE PATH !!!");
		int nickPosition=1;
		int passwordPosition=2;
		int groupPosition=5;
		listOfAllHumans.addAll(fileWorkers.listOfUsers());
		listOfAllHumans.addAll(fileStudents.listOfUsers());
		for(String[] user : listOfAllHumans){
				if(user[nickPosition].equals(nick) && user[passwordPosition].equals(password))
					return user[groupPosition];
			System.out.println(user[nickPosition]+" "+user[passwordPosition]);
		}
		return "Login or password is invalid";
		
	}
	
	public static void main(String[] args){
	
	
		LogIn login = new LogIn();
		System.out.println(login.FindGroupByLogin("Login1","Password1"));
	
	}
	
	
}