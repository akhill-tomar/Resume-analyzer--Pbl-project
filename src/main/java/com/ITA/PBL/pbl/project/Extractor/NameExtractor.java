package com.ITA.PBL.pbl.project.Extractor;

import java.io.*;
import opennlp.tools.namefind.*;
import opennlp.tools.util.*;
import java.nio.charset.StandardCharsets;

public class NameExtractor {

    public static String extractName(String text) throws IOException {
        InputStream modelIn = new FileInputStream("src/main/resources/en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
        NameFinderME nameFinder = new NameFinderME(model);

        String[] tokens = text.split("\\s+");
        Span[] nameSpans = nameFinder.find(tokens);

        if (nameSpans.length > 0) {
            return tokens[nameSpans[0].getStart()] + " " + tokens[nameSpans[0].getEnd() - 1];
        }
        return "Name not found";
    }
}
