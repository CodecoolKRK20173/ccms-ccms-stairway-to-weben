package com.codecool.dao;

import com.codecool.model.Mentor;

import java.util.List;

public interface MentorDAO {
    Mentor getMentor(String id);
    List<Mentor> getListOfMentors();
    void createMentor(Mentor mentor);
    void deleteMentor(String id);
    void updateMentor(Mentor mentor);

}
