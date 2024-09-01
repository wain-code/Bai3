package iuh.fit.se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: This class represents a list of courses and provides methods to manage and search for courses.
 * Author: Huynh Minh Thu
 * Date: 8/27/2024
 * Version: 1.0
 */
public class CourseList {

    private Course[] courses;
    private static int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        this.courses = new Course[n]; // create an array of n elements
    }

    public Course[] getCourses() {
        return this.courses;
    }


    /**
     * Description: Add a course to the list
     * @param course
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course) {
        //  check if course is null
        if(course == null)
            return false;
        //  check if course already exists
        if(exists(course)) //Check if id of course duplicate
            return false;
        //  check if the array is full
        if (this.count==this.courses.length)
            return false;
        //  add course to the array
        this.courses[this.count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean exists(Course course) {
        for(int i = 0; i < this.count; ++i) {
            if (this.courses[i].getId().equalsIgnoreCase(course.getId())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove a course from the list based on its ID.
     * @param courseID The ID of the course to remove.
     * @return true if the course is removed successfully, false otherwise.
     */
    public boolean removeCourse(String courseID) {
        if (courseID != null && !courseID.isEmpty()) {
            for(int i = 0; i < this.count; ++i) {
                if (this.courses[i].getId().equalsIgnoreCase(courseID)) {
                    for(int j = i; j < this.count - 1; ++j) {
                        this.courses[j] = this.courses[j + 1];
                    }
                    this.courses[this.count - 1] = null;
                    --this.count;
                    return true;
                }
            }
            System.out.println("Course not found");
            return false;
        } else {
            throw new IllegalArgumentException("No course exists!");
        }
    }

    /**
     * Search for courses by name (partial match).
     *
     * @param courseTittle The name or part of the name to search for.
     * @return A list of courses that match the search criteria.
     */
    public Course[] searchCourse(String courseTittle) {
        return null;
    }

    /**
     * Search for courses by department.
     * @param courseDepartment The department to search for.
     * @return A list of courses that belong to the specified department.
     */
    public Course[] searchCourseByDepartment(String courseDepartment) {
        for(int i = 0; i < this.count; ++i) {
            if (this.courses[i].getDepartment().equalsIgnoreCase(courseDepartment)) {
                System.out.println(this.courses[i]);
            }
        }
        return null;
    }

    public Course searchCourseByID(String courseID) {
        for(int i = 0; i < this.count; ++i) {
            if (this.courses[i].getId().equalsIgnoreCase(courseID)) {
                return this.courses[i];
            }
        }
        return null;
    }

    public Course[] sortCourse() {
        Course[] copyCourse = (Course[])Arrays.copyOf(this.courses, this.count);
        for(int i = 0; i < this.count - 1; ++i) {
            for(int j = i + 1; j < this.count; ++j) {
                if (copyCourse[i].getTitle().compareTo(copyCourse[j].getTitle()) > 0) {
                    Course temp = copyCourse[i];
                    copyCourse[i] = copyCourse[j];
                    copyCourse[j] = temp;
                }
            }
        }
        return copyCourse;
    }

    public Course getCourseByID(String id) {
        return null;
    }

    public List<Course> searchCourseByTitle(String title) {
        return List.of();
    }

    public void sortCourses() {
    }

    public Course getCourseByTitle(String title) {
        return null;
    }
}

