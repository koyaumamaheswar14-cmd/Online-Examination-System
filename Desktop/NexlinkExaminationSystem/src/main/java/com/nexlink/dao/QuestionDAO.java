package com.nexlink.dao;

import com.nexlink.model.Question;
import com.nexlink.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    // 🔹 1. Get questions by exam + section
    public List<Question> getQuestionsBySection(int examId, String section) {

        List<Question> list = new ArrayList<>();

        String sql = """
            SELECT id, question,
                   optionA, optionB, optionC, optionD,
                   answer, section
            FROM questions
            WHERE exam_id = ?
              AND TRIM(LOWER(section)) = TRIM(LOWER(?))
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ps.setString(2, section);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question q = new Question();

                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));

                // answer is VARCHAR (A/B/C/D)
                q.setCorrectOption(rs.getString("answer"));
                q.setSection(rs.getString("section"));

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 2. Get all sections for an exam (THIS FIXES YOUR ERROR)
    public List<String> getSectionsByExam(int examId) {

        List<String> sections = new ArrayList<>();

        String sql = """
            SELECT DISTINCT TRIM(section) AS section
            FROM questions
            WHERE exam_id = ?
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                sections.add(rs.getString("section"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sections;
    }

	
}
