package com.example.interview.util;

import com.example.interview.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringValidation {
    public void elementsValidation(String[] elements) {
        emptyArrayValidation(elements);
        elementOutOfFormatValidation(elements);
    }

    private void elementOutOfFormatValidation(String[] elements) {
        for (String element : elements) {
            if (element.startsWith("-")) {
                throw new BadRequestException("Elemento " + element + " não pertence aos {0,1...15}");
            } else {
                if (!element.matches("^[0-9]*$")) {
                    throw new BadRequestException("Elemento " + element + " não é um número");
                }
            }
            if (Integer.parseInt(element) > 15) {
                throw new BadRequestException("Elemento " + element + " fora do intervalo");
            }
        }
    }

    private void emptyArrayValidation(String[] elements) {
        if (elements == null || elements.length == 0) {
            throw new BadRequestException("Array[n] não pode ser vazio");
        }
    }


}
