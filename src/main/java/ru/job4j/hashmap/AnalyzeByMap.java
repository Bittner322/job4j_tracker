package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                list.add(subject.score());
            }
        }

        int total = 0;
        for (int score : list) {
            total += score;
        }
        return (double) total / list.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        HashMap<Pupil, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(pupil, subject.score());
            }
        }

        ArrayList<Label> labels = new ArrayList<>();
        for (Pupil pupil : map.keySet()) {
            int total = 0;
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
            }
            double average = (double) total / pupil.subjects().size();
            labels.add(new Label(pupil.name(), average));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<Pupil, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(pupil, subject.score());
            }
        }

        ArrayList<Label> labels = new ArrayList<>();
        HashMap<Subject, Integer> tempMap = new HashMap<>();
        for (Pupil pupil : map.keySet()) {
            for (Subject subject : pupil.subjects()) {
                tempMap.put(subject, subject.score());
            }
        }
        for (Pupil pupil : map.keySet()) {
            int total = 0;
            int counter = 0;
            String subjectName = pupil.subjects().get(counter).name();
            for (Subject subject : tempMap.keySet()) {
                if (subject.name().equals(subjectName)) {
                    total += subject.score();
                }
                counter++;
            }
            labels.add(new Label(subjectName, (double) total / pupil.subjects().size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        HashMap<Pupil, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(pupil, subject.score());
            }
        }

        ArrayList<Label> labels = new ArrayList<>();
        for (Pupil pupil : map.keySet()) {
            int total = 0;
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
            }
            labels.add(new Label(pupil.name(), total));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<Subject, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject, subject.score());
            }
        }

        ArrayList<Label> labels = new ArrayList<>();
        HashMap<Subject, Integer> tempMap = new HashMap<>();
        for (Subject subject : map.keySet()) {
            int total = 0;
            tempMap.put(subject, subject.score());
            for (Subject tempSubject : tempMap.keySet()) {
                if (tempSubject.name().equals(subject.name())) {
                    total += tempSubject.score();
                }
            }
            labels.add(new Label(subject.name(), total));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }
}