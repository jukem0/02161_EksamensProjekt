package com.projectmanager.model;

public class Week {
    int weekNum, year;

    public Week(int weekNum, int year) {
        this.weekNum = weekNum;
        this.year = year;
    }

    public boolean isAfter(Week secondWeek) {
        if (secondWeek.getYear() > year) {
            return false;
        } else if (secondWeek.getYear() < year) {
            return true;
        } else if (secondWeek.getWeekNum() > weekNum) {
            return false;
        } else {
            return true;
        }
    }

    public int getWeekNum() {
        return weekNum;
    }

    public int getYear() {
        return year;
    }
}
