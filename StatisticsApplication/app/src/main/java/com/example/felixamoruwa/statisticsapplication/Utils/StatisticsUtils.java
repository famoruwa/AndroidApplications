package com.example.felixamoruwa.statisticsapplication.Utils;

/**
 * Created by felixamoruwa on 7/15/15.
 */

import com.example.felixamoruwa.statisticsapplication.model.Student;

import java.util.ArrayList;


public class StatisticsUtils {
    private int[] lowScores = {100,100,100,100,100};
    private int[] highScores = {0,0,0,0,0};
    private double[] avgScores = {0,0,0,0,0};

    public void findLow(ArrayList<Student> students) {

        for(int i=0; i<students.size(); i++) {
            int[] currentScores = students.get(i).getScores();
            for(int j=0; j<5; j++) {
                if(currentScores[j]<lowScores[j])
                    lowScores[j] = currentScores[j];
            }
        }
    }

    public void findHigh(ArrayList<Student> students) {
        for(int i=0; i<students.size(); i++) {
            int[] currentScores = students.get(i).getScores();
            for(int j=0; j<5; j++) {
                if(currentScores[j]>highScores[j])
                    highScores[j] = currentScores[j];
            }
        }
    }

    public void findAvg(ArrayList<Student> students) {
        //Sum all the scores
        for(int i=0; i<students.size(); i++) {
            int[] currentScores = students.get(i).getScores();
            avgScores[0] += currentScores[0];
            avgScores[1] += currentScores[1];
            avgScores[2] += currentScores[2];
            avgScores[3] += currentScores[3];
            avgScores[4] += currentScores[4];
        }

        //Divide by number of scores to get average
        for(int j=0; j<5; j++) {
            avgScores[j] = avgScores[j]/students.size();
        }
    }

    public void generateStatistics(ArrayList<Student> students) {
        findLow(students);
        findHigh(students);
        findAvg(students);
    }

    public int[] getLowScores() {
        return lowScores;
    }

    public int[] getHighScores() {
        return highScores;
    }

    public double[] getAvgScores() {
        return avgScores;
    }
}

