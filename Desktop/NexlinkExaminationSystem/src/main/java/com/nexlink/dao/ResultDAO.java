package com.nexlink.dao;

import com.nexlink.model.ExamResult;
import com.nexlink.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResultDAO {

    public void saveSectionResult(ExamResult r) {

        System.out.println("🔥 saveSectionResult() called");

        String sql =
            "INSERT INTO exam_results " +
            "(user_id, user_name, section, total_questions, correct, incorrect, unanswered) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getUserId());
            ps.setString(2, r.getUserName());
            ps.setString(3, r.getSection());
            ps.setInt(4, r.getTotalQuestions());
            ps.setInt(5, r.getCorrect());
            ps.setInt(6, r.getIncorrect());
            ps.setInt(7, r.getUnanswered());

            int rows = ps.executeUpdate();

            System.out.println("✅ INSERT ROWS = " + rows);

        } catch (Exception e) {
            System.out.println("❌ INSERT FAILED");
            e.printStackTrace();
        }
    }
}
