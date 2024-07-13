package com.aj.service;

import com.aj.entity.Student;
import com.aj.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {
    private static final String FILE_PATH = "students.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Student> getAllStudents() {
        return readStudentsFromFile();
    }

    public Optional<Student> getStudentById(Long id) {
        return readStudentsFromFile().stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public Student createStudent(Student student) {
        List<Student> students = readStudentsFromFile();
        student.setId(idCounter.incrementAndGet());
        students.add(student);
        writeStudentsToFile(students);
        return student;
    }

    public Student updateStudent(Long id, Student studentDetails) {
        List<Student> students = readStudentsFromFile();
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        student.setContactNumber(studentDetails.getContactNumber());
        writeStudentsToFile(students);
        return student;
    }

    public void deleteStudent(Long id) {
        List<Student> students = readStudentsFromFile();
        students.removeIf(student -> student.getId().equals(id));
        writeStudentsToFile(students);
    }

    private List<Student> readStudentsFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        } catch (IOException e) {
            throw new RuntimeException("Error reading students from file", e);
        }
    }

    private void writeStudentsToFile(List<Student> students) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), students);
        } catch (IOException e) {
            throw new RuntimeException("Error writing students to file", e);
        }
    }
}
