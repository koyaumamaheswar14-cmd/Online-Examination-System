package com.nexlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nexlink.model.Exam;
import com.nexlink.util.DBConnection;

public class ExamDAO {

    // Fetch exam by ID
    public Exam getExamById(int examId) {
        Exam exam = null;

        String sql = "SELECT * FROM exams WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exam = new Exam();
                exam.setId(rs.getInt("id"));
                exam.setTitle(rs.getString("title"));
                exam.setDuration(rs.getInt("duration"));
                exam.setTotalQuestions(rs.getInt("total_questions"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exam;
    }
}
