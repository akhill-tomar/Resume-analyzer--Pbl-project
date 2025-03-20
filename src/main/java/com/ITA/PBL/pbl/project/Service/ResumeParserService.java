package com.ITA.PBL.pbl.project.Service;

import com.ITA.PBL.pbl.project.Extractor.NameExtractor;
import com.ITA.PBL.pbl.project.Extractor.ResumeInfoExtractor;
import com.ITA.PBL.pbl.project.Extractor.SkillExtractor;
import com.ITA.PBL.pbl.project.Model.ResumeData;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;

    @Service
    public class ResumeParserService {

        private final Tika tika = new Tika();

        public String extractTextFromFile(File file) {
            try {
                String text = tika.parseToString(file);
                System.out.println("Extracted Text: \n" + text); // Log the text
                return text;
            } catch (IOException | TikaException e) {
                e.printStackTrace();
                return "Error parsing the file";
            }
        }

        public ResumeData extractResumeData(String text) throws IOException {
            String name = NameExtractor.extractName(text);    // For Name
            String email = ResumeInfoExtractor.extractEmail(text);   // For Email
            String phone = ResumeInfoExtractor.extractPhoneNumber(text);   // For Phone
            List<String> skills = SkillExtractor.extractSkills(text);  // For Skills

            return new ResumeData(name, email, phone, skills);
        }
    }

