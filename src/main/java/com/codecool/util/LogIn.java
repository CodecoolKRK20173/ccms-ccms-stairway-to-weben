package com.codecool.util;
import com.codecool.dao.FileParser;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
public class LogIn{

	private String group="";

	private FileParser fileWorkers;
	private FileParser fileStudents;
	
	private List<String[]> listOfAllHumans;
	public LogIn(){
	
		this.listOfAllHumans = new ArrayList<>();
		
	}
	
	public String findGroupByLogin(String nick, String password){
		this.fileWorkers=new FileParser("/home/trauke/codecool/javaa/6tw/ccms-ccms-stairway-to-weben/src/main/java/com/codecool/dao/Workers");
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
	public Boolean doNotDuplicateNickNames(String nick){
	    listOfAllHumans = new ArrayList<>();
	    this.fileWorkers=new FileParser("/home/trauke/codecool/javaa/6tw/ccms-ccms-stairway-to-weben/src/main/java/com/codecool/dao/Workers");
       // this.fileStudents= new FileParser("STUDENTS FILE PATH !!!");
        int nickPosition=1;
        listOfAllHumans.addAll(fileWorkers.listOfUsers());
        //listOfAllHumans.addAll(fileStudents.listOfUsers());
        for(String[] user : listOfAllHumans){
            if(user[1].equals(nick)){
                System.out.println("This nick already exist.");
                return true;
            }
        }return false;
    }

}
