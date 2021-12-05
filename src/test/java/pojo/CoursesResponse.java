package pojo;

import lombok.Data;

@Data
public class CoursesResponse {

    private String url;
    private String services;
    private String expertise;
    private Courses courses;
    private String instructor;
    private String linkedIn;

}
