package com.ITA.PBL.pbl.project.controller;

import com.ITA.PBL.pbl.project.Model.ResumeData;
import com.ITA.PBL.pbl.project.Service.ResumeParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeParserService resumeParserService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) {
        try {
            // Convert MultipartFile to a temporary file
            File tempFile = File.createTempFile("uploaded-resume", ".txt");
            file.transferTo(tempFile);

            // Extract text from resume
            String resumeText = resumeParserService.extractTextFromFile(tempFile);

            // Extract relevant details
            ResumeData resumeData = resumeParserService.extractResumeData(resumeText);

            // Delete temporary file after use
            tempFile.delete();

            return new ResponseEntity<>(resumeData, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to process the resume", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}