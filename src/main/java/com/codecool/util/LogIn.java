package com.codecool.util;
import com.codecool.dao.FileParser;
import com.codecool.view.MasterView;

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
		this.fileWorkers=new FileParser("src/main/java/com/codecool/dao/Workers");
		this.fileStudents= new FileParser("src/main/java/com/codecool/student.csv");
		int nickPosition=1;
		int passwordPosition=2;
		int groupPosition=5;
		listOfAllHumans.addAll(fileWorkers.listOfUsers());
		listOfAllHumans.addAll(fileStudents.listOfUsers());
		for(String[] user : listOfAllHumans){
				if(user[nickPosition].equals(nick) && user[passwordPosition].equals(password))
					return user[groupPosition];
		}
        System.out.println("Wrong login or password");
		return "0";
	}

	public Boolean doNotDuplicateNickNames(String nick){
	    listOfAllHumans = new ArrayList<>();
	    this.fileWorkers=new FileParser("src/main/java/com/codecool/dao/Workers");
        this.fileStudents= new FileParser("src/main/java/com/codecool/student.csv");
        int nickPosition=1;
        listOfAllHumans.addAll(fileWorkers.listOfUsers());
        listOfAllHumans.addAll(fileStudents.listOfUsers());
        for(String[] user : listOfAllHumans){
            if(user[1].equals(nick)){
                System.out.println("This nick already exist.");
                return true;
            }
        }return false;
    }
}
