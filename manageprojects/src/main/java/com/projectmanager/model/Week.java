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

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(obj.getClass() != this.getClass()){
            return false;
        }

        final Week other = (Week) obj;
        return (getWeekNum() == other.getWeekNum() && getYear() == other.Year());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(weekNum, year);
    }
}
