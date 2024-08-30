/*
 * @ (#) CourseList.java    1.0  8/30/2024
 *
 *Copyright (c) 2024 IUH.All rights reserved
 */
package edu.iuh.fit;
import javax.swing.plaf.ColorUIResource;
import java.lang.reflect.Array;
import java.util.*;
/*
 * @description:This class represents a bank with many bank accounts
 * @author: Thu Phuong
 * @version: 1.0
 * @date:8/30/2024
 */
public class CourseList {
    private Course[] courses;
    private static int count = 0;

    public CourseList(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Length must be greater than 0");
        courses = new Course[n];
        this.courses = courses;
    }

    // Thêm một khóa học vào danh sách
    public boolean addCourse(Course course) {
        if (course == null)
            return false;
        if (exists(course))
            return false;
        if (count == courses.length)
            return false;
        courses[count++] = course;
        return true;
    }

    //
    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(course.getId()))
                return true;
        }
        return false;
    }

    // Xóa một khóa học khỏi danh sách
    public boolean removeCourse(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(courseId)) {
                for (int j = i ; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        return false;
    }
    public Course[] getCourses() {
        return courses;
    }

    // Tìm khoa có nhiều khóa học nhất trong danh sách
    public String findDepartmentWithMostCourses() {
        Map<String, Integer> departmentCount = new HashMap<>();

        for (int i = 0; i < count; i++) {
            Course course = courses[i];
            if (course != null) {
                String department = course.getDepartment();
                departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
            }
        }

        String departmentWithMostCourses = null;
        int maxCourses = 0;

        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCourses) {
                maxCourses = entry.getValue();
                departmentWithMostCourses = entry.getKey();
            }
        }

        return departmentWithMostCourses;
    }

    // Tìm khóa học có số tín chỉ lớn nhất
    public Course findMaxCreditCourse() {
        if (count == 0) {
            return null; // Trường hợp danh sách rỗng
        }

        Course maxCreditCourse = courses[0];
        boolean allSameCredit = true;

        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > maxCreditCourse.getCredit()) {
                maxCreditCourse = courses[i];
                allSameCredit = false;
            } else if (courses[i].getCredit() < maxCreditCourse.getCredit()) {
                allSameCredit = false;
            }
        }
        return allSameCredit ? null : maxCreditCourse;
    }


    //Tìm kiếm khóa học theo khoa phụ trách
    public List<Course> searchCoursesByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(courses[i] != null && courses[i].getDepartment().equals(department)) {
                result.add(courses[i]);
            }
        }
        return result;
    }

    // Tìm kiếm khóa học theo mã khóa học
    public Course searchCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(courseId)) {
                return courses[i];
            }
        }
        return null;
    }

    //Sắp xếp danh sách khóa học không theo danh sách gốc
    public void sortCoursesByID() {
        Arrays.sort(courses,0,count,Comparator.comparing(Course::getId));
    }
}




