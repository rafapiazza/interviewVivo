package com.example.interview.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageBitmapMock {
    private String[][] imageBitmap;

    public String[][] initiateImageBitmap(int row, int column) {
        this.imageBitmap = new String[row][column];
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                imageBitmap[rowIndex][columnIndex] = String.valueOf(Math.random() * 16);
            }
        }
        return imageBitmap;
    }

    public String[][] initiateImageBitmap() {
        this.imageBitmap = new String[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                imageBitmap[row][column] = String.valueOf((int) (Math.random() * 16));
            }
        }
        return imageBitmap;
    }

    public String printMap(String[][] map) {
        StringBuilder returnMap = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                returnMap.append(map[i][j]);
                returnMap.append(" ");
            }
            returnMap.append("\n");
        }
        return returnMap.toString();
    }

    public String printOccurrences(String[] elements, int[] elementOccurrences) {
        StringBuilder occurrences = new StringBuilder();
        for (int index = 0; index < elements.length; index++) {
            occurrences.append("Elemento ")
                    .append(elements[index])
                    .append(" encontrado ")
                    .append(elementOccurrences[index])
                    .append(" vezes")
                    .append("\n");
        }
        return occurrences.toString();
    }
}
