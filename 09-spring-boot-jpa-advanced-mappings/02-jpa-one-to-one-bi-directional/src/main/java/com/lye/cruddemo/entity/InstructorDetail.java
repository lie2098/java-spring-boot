package com.lye.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "instructorDetail")
//    @OneToOne(mappedBy = "instructorDetail",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @ToString.Exclude // just add the toString() and remove the instructor to fix  Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate cruddemo.entity.Instructor.toString()
    private Instructor instructor;
}
