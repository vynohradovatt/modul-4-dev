package org.example.dto;

public class MaxProjectClient {
    private String name;
    private int project_count;

    public MaxProjectClient(String name, int project_count) {
        this.name = name;
        this.project_count = project_count;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", project_count=" + project_count +
                '}';
    }
}
