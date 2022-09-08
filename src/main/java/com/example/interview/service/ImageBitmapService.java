package com.example.interview.service;

import com.example.interview.util.ImageBitmapMock;
import com.example.interview.util.StringValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ImageBitmapService {
    private final ImageBitmapMock imageBitmapMock;
    private final StringValidation stringValidation;

    public String findOccurrences(String[] elements) {
        stringValidation.elementsValidation(elements);
        String[][] imageMap = imageBitmapMock.initiateImageBitmap();
        int[] elementOccurrences = getNumberOfOccurrencesInMap(elements, imageMap);

        return imageBitmapMock.printOccurrences(elements, elementOccurrences);
    }

    private int[] getNumberOfOccurrencesInMap(String[] elements, String[][] imageMap) {
        int[] elementOccurrences = new int[elements.length];

        for (int rowIndex = 0; rowIndex < elements.length; rowIndex++) {
            int index = rowIndex;
            Arrays.stream(imageMap).forEach(mapRow -> {
                Arrays.stream(mapRow).forEach(mapElement -> {
                    if (mapElement.equals(elements[index])) {
                        elementOccurrences[index]++;
                    }
                });
            });
        }
        return elementOccurrences;
    }
}
