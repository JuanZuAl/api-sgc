package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.repository.CourseRepository;
import co.github.JuanZuAl.services.CourseService;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {

    CourseService courseService;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseService = courseService;
    }


}