package org.example.dto;

public class ProjectPrices {
    private String nameOfProject;
    private int priceOfProject;

    public ProjectPrices(String nameOfProject, int priceOfProject) {
        this.nameOfProject = nameOfProject;
        this.priceOfProject = priceOfProject;
    }

    @Override
    public String toString() {
        return "nameOfProject='" + nameOfProject + '\'' +
                ", priceOfProject=" + priceOfProject +
                '}';
    }
}
