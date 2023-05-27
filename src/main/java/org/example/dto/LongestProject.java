package org.example.dto;

public class LongestProject {
    private String name;
    private int month_count;

    public LongestProject(String name, int month_count) {
        this.name = name;
        this.month_count = month_count;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", month_count=" + month_count +
                '}';
    }
}
