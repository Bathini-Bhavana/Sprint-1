package com.student;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class courseDAO {
    private EntityManager em;

    public courseDAO(EntityManager em) {
        this.em = em;
    }

    // Method to add course details
    public void createCourse(course course) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }

            em.persist(course);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }

    // Method to update a course
    public void updateCourse(int id, String newCourseName, String newCourseCode) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();

            if (!et.isActive()) {
                et.begin();
            }

            course course = em.find(course.class, id);
            if (course != null) {
                course.setCourseName(newCourseName);
                course.setCourseCode(newCourseCode);
                em.merge(course);
                et.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }

    // Method to get details of a specific course
    public Optional<course> getById(int id) {
        course course = em.find(course.class, id);

        if (course != null) {
            return Optional.of(course);
        } else {
            return Optional.empty();
        }
    }

    // Method to get all courses
    public List<course> getAll() {
        List<course> courses = em.createQuery("from Course", course.class).getResultList();
        return courses;
    }

    // Method to remove a course by ID
    public void removeById(int id) {
        EntityTransaction et = null;

        course course = em.find(course.class, id);

        try {
            et = em.getTransaction();

            if (!et.isActive()) {
                et.begin();
            }

            em.remove(course);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }
}