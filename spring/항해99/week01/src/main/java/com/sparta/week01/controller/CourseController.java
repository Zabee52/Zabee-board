package com.sparta.week01.controller;

import com.sparta.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController 선언
@RestController
public class CourseController {

    // 주소 뒤에 /courses를 입력시 보여줄 화면
    @GetMapping("/courses")
    public Course getCourses() {
        Course course = new Course();
        course.setTitle("웹개발의 봄 스프링");
        course.setDays(35);
        course.setTutor("남병관");

        // class 형식으로 반환시키면 Spring이 알아서 JSON 형식으로 변환해서 출력해줌.
        return course;
    }
}