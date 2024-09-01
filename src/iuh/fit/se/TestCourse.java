/*
 * @ (#) $NAME.java  1.0     8/27/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package iuh.fit.se;

import java.util.List;
import java.util.Scanner;

/*
 * @description:
 * @outhor: Huynh Minh Thu
 * @date: 8/27/2024
 * @version: 1.0
 */
public class TestCourse {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Search Course By ID");
            System.out.println("5. Search Course By Title");
            System.out.println("6. Search Course By Department");
            System.out.println("7. Sort Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.printf("%-10s%-30s%2s %-10s%n", "ID", "Title", "Credit", "Department");
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.print("Enter Course ID to remove: ");
                    String id = sc.next();
                    if (courseList.removeCourse(id)) {
                        System.out.println("Course removed successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                }
                case 4 -> {
                    // Tìm kiếm khóa học theo ID
                    System.out.print("Enter course ID to search: ");
                    String searchID = sc.nextLine();
                    Course courseByID = courseList.searchCourseByID(searchID);
                    System.out.println(courseByID != null ? courseByID : "Course not found.");
                }
                case 5 -> {
                    // Tìm kiếm khóa học theo tiêu đề
                    System.out.print("Enter course title to search: ");
                    String searchTitle = sc.nextLine();
                    Course[] coursesByTitle = courseList.searchCourse(searchTitle);
                    if (coursesByTitle != null) {
                        for (Course c : coursesByTitle) {
                            if (c != null) {
                                System.out.println(c);
                            }
                        }
                    } else {
                        System.out.println("No courses found.");
                    }
                }
                case 6 -> {
                    // Tìm kiếm khóa học theo khoa
                    System.out.print("Enter department to search: ");
                    String searchDepartment = sc.nextLine();
                    Course[] coursesByDepartment = courseList.searchCourseByDepartment(searchDepartment);
                    if (coursesByDepartment != null) {
                        for (Course c : coursesByDepartment) {
                            if (c != null) {
                                System.out.println(c);
                            }
                        }
                    } else {
                        System.out.println("No courses found.");
                    }
                }
                case 7 -> {
                    // Sắp xếp các khóa học
                    Course[] sortedCourses = courseList.sortCourse();
                    for (Course c : sortedCourses) {
                        System.out.println(c);
                    }
                }
                case 0 -> {
                    // Thoát khỏi chương trình
                    System.out.println("Exiting...");
                }
            default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "SE");
        Course course2 = new Course("FIT102", "Web Programming", 2, "SE");
        Course course3 = new Course("FIT103", "Database Programming", 3, "DA");
        Course course4 = new Course("FIT104", "Mobile Programming", 2, "IS");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "SE");
        Course course6 = new Course("FIT106", "Data Science", 3, "DA");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "CS");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "CS");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }
}