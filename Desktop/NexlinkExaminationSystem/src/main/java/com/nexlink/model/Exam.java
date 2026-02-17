package com.nexlink.model;

public class Exam {

    private int id;
    private String title;
    private int duration;
    private int totalQuestions;

    public Exam() {}

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public int getDuration() { 
        return duration; 
    }
    public void setDuration(int duration) { 
        this.duration = duration; 
    }

    public int getTotalQuestions() { 
        return totalQuestions; 
    }
    public void setTotalQuestions(int totalQuestions) { 
        this.totalQuestions = totalQuestions; 
    }
}
