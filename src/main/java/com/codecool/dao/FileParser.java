package com.codecool.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileParser {
    private List<String[]> listOfUsers;
    private String fileName;
    private String fileContent;
    private String[] splitedFileContent;

    public FileParser(String file) {
        listOfUsers = new ArrayList<>();
        this.fileName = file;
    }

    public List<String[]> getList() {
        return this.listOfUsers();
    }


    public void loadFile() {
        this.fileContent = "";
        try {
            File file = new File(this.fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                fileContent += sc.nextLine();
                fileContent += "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void splitFileContent() {
        this.listOfUsers = new ArrayList<>();
        this.splitedFileContent = this.fileContent.split("\\r?\\n");
        for (String line : splitedFileContent) {
            this.listOfUsers.add(line.split("\\|"));
        }
    }

    public List<String[]> listOfUsers() {
        loadFile();
        splitFileContent();
        return this.listOfUsers;
    }


    public void addNewRecord(String newRecordToFile) {
        try {
            FileWriter fw = new FileWriter(this.fileName, true);
            fw.write(newRecordToFile + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewRecord(String[] newRecord) {
        String newRecordToFile = String.join("|", newRecord) + "|";
        addNewRecord(newRecordToFile);
    }

    public void saveUploadedListInFile(List<String[]> list) {
        String newContent = "";
        for (String[] array : list) {
            for (int i = 0; i < array.length; i++) {
                newContent += array[i];
                newContent += "|";
            }
            newContent += "\n";

        }

        try {
            FileWriter fw = new FileWriter(this.fileName, false);
            fw.write(newContent);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
