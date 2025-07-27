package com.codewithaman;

import java.util.*;

public class Profile {
    private String headline;
    private String summary;
    private List<Skill> skills = new ArrayList<>();
    private List<Experience> experiences = new ArrayList<>();
    private List<Education> educationList = new ArrayList<>();

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void addExperience(Experience experience) {
        experiences.add(experience);
    }

    public void addEducation(Education edu) {
        educationList.add(edu);
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
}
