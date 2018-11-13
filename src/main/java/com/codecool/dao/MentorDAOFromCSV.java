package com.codecool.dao;

import com.codecool.model.Mentor;

import java.util.ArrayList;
import java.util.List;

public class MentorDAOFromCSV implements MentorDAO{
    private FileParser fileParser;
    private List<String []> listOfArrays;
    private String MentorGroup = "3";
    private int MentorGroupNumber = 3;
    private Mentor mentor;

    public MentorDAOFromCSV(){
        FileParser fileParser = new FileParser("ccms-ccms-stairway-to-weben/src/main/java/com/codecool/dao/Workers");
        listOfArrays = new ArrayList<>();
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
    public void createMentor(Mentor mentor) {

    }

    @Override
    public void deleteMentor(String id) {

    }

    @Override
    public void updateMentor(Mentor mentor) {

    }
}
