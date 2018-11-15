package com.codecool.dao;

import com.codecool.model.Mentor;
import com.codecool.util.LogIn;
import com.codecool.view.MentorView;

import java.util.ArrayList;
import java.util.List;

public class MentorDAOFromCSV implements MentorDAO{
    private FileParser fileParser;
    private List<String []> listOfArrays;
    private String MentorGroup = "3";
    private int MentorGroupNumber = 3;
    private Mentor mentor;
    private MentorView mentorView = new MentorView();
    private LogIn logIn = new LogIn();

    public MentorDAOFromCSV(){
        this.fileParser = new FileParser("src/main/java/com/codecool/dao/Workers");
        this.listOfArrays = new ArrayList<>();
    }
    @Override
    public Mentor getMentor(String id) {
        this.listOfArrays = fileParser.listOfUsers();
        for (int i = 0; i < listOfArrays.size(); i++) {
            if (listOfArrays.get(i)[0].equals(id) && listOfArrays.get(i)[5].equals(MentorGroup)){
                this.mentor = new Mentor(listOfArrays.get(i)[0],listOfArrays.get(i)[1],listOfArrays.get(i)[2],listOfArrays.get(i)[3],listOfArrays.get(i)[4],MentorGroupNumber);
            }
        }
        return mentor;
    }

    public String toString(Mentor mentor){
        String newMentor = "";
        newMentor += mentor.getId();
        newMentor += "|";
        newMentor += mentor.getUserName();
        newMentor += "|";
        newMentor += mentor.getPassword();
        newMentor += "|";
        newMentor += mentor.getName();
        newMentor += "|";
        newMentor += mentor.getSurname();
        newMentor += "|";
        newMentor += "3";
        newMentor += "|";
        return  newMentor;
    }

    @Override
    public List<Mentor> getListOfMentors() {
        this.listOfArrays = fileParser.listOfUsers();
        List<Mentor> mentors = new ArrayList<>();
        for (int i = 0; i < listOfArrays.size(); i++) {
            if (listOfArrays.get(i)[5].equals(MentorGroup)){
                mentors.add(new Mentor(listOfArrays.get(i)[0],listOfArrays.get(i)[1],listOfArrays.get(i)[2],listOfArrays.get(i)[3],listOfArrays.get(i)[4],MentorGroupNumber));
            }
        }
        return mentors;
    }

    @Override
    public void createMentor() {
        Mentor mentor = null;
        String id;
        String userName;
        String password;
        String name;
        String surname;
        int group;
        mentorView.print("Enter id: ");
        id = mentorView.input();
        do {
            mentorView.print("Enter user name: ");
            userName = mentorView.input();
        }while (logIn.doNotDuplicateNickNames(userName));
        mentorView.print("Enter your password: ");
        password = mentorView.input();
        mentorView.print("Enter your name: ");
        name = mentorView.input();
        mentorView.print("Enter your surname: ");
        surname = mentorView.input();
        mentor = new Mentor(id,userName,password,name,surname,3);
        String toStringMentor = toString(mentor);
        fileParser.addNewRecord(toStringMentor);
    }

    @Override
    public void deleteMentor() {
        String nick = "";
        mentorView.print("Enter mentor's nick to delete it");
        nick = mentorView.input();
        this.listOfArrays = fileParser.listOfUsers();
        for (int i = 0; i <listOfArrays.size() ; i++) {
            if(listOfArrays.get(i)[1].equals(nick)){
                listOfArrays.remove(i);
            }
        }
        fileParser.saveUploadedListInFile(listOfArrays);


    }

    @Override
    public void updateMentor(Mentor mentor) {

    }

}
