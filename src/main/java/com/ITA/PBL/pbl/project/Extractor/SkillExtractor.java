package com.ITA.PBL.pbl.project.Extractor;

import java.util.*;

public class SkillExtractor {

    private static final List<String> SKILL_LIST = Arrays.asList(
            "Java", "Spring Boot", "Hibernate", "MySQL", "REST API", "Docker"
    );

    public static List<String> extractSkills(String text) {
        List<String> skillsFound = new ArrayList<>();
        for (String skill : SKILL_LIST) {
            if (text.toLowerCase().contains(skill.toLowerCase())) {
                skillsFound.add(skill);
            }
        }
        return skillsFound;
    }
}
