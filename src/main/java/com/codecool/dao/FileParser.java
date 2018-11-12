package com.codecool.dao;

import java.util.*;
import java.io.*;



public class FileParser {
	private List<String[]> listOfUsers;
	private String fileName;
	private String fileContent;
	private String[] splitedFileContent;
	
	public FileParser(String file){
		listOfUsers=new ArrayList<>();
		this.fileName=file;
	}
	
	
	public void loadFile(){
	
		this.fileContent="";
		try{
			File file = new File(this.fileName);
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
			
				fileContent += sc.nextLine();
			
			}
		sc.close();
		}
		catch(FileNotFoundException e){
			
			System.out.println("There is no file like "+this.fileName);
		
		}
	
		
	}

	public void splitFileContent(){
	
		this.splitedFileContent=this.fileContent.split("\\r?\\n");
		for(String line : splitedFileContent){
			this.listOfUsers.add(line.split("\\|"));
		}
	}	
	
	public List<String[]> listOfUsers(){
	
	
		loadFile();
		splitFileContent();
	
		return this.listOfUsers;
	}

	
}