package com.example.interview;

import com.example.interview.exception.BadRequestException;
import com.example.interview.service.ImageBitmapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ImageBitmapServiceTest {

    @Autowired
    private ImageBitmapService imageBitmapService;


//    @InjectMocks
//    private ImageBitmapMock imageBitmapMock;

    @Test
    void imageBitMapWithEmptyList() {
        String[] emptyString = new String[0];
        BadRequestException thrown = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(emptyString)
        );
        assertEquals("Array[n] não pode ser vazio", thrown.getMessage());
    }

    @Test
    void imageBitMapWithNumberOutOfInterval() {
        String[] invalidString1 = {"0", "2", "16"};
        BadRequestException thrown1 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString1)
        );
        String[] invalidString2 = {"500", "4"};
        BadRequestException thrown2 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString2)
        );

        assertEquals("Elemento 16 fora do intervalo", thrown1.getMessage());
        assertEquals("Elemento 500 fora do intervalo", thrown2.getMessage());
    }

    @Test
    void imageBitMapWithNegativeNumber() {
        String[] invalidString1 = {"0", "2", "-4"};
        BadRequestException thrown1 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString1)
        );
        String[] invalidString2 = {"-236", "4"};
        BadRequestException thrown2 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString2)
        );

        assertEquals("Elemento -4 não pertence aos {0,1...15}", thrown1.getMessage());
        assertEquals("Elemento -236 não pertence aos {0,1...15}", thrown2.getMessage());
    }

    @Test
    void imageBitMapWithInvalidFormat() {
        String[] invalidString1 = {"0", "c1", "15"};
        BadRequestException thrown1 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString1)
        );
        String[] invalidString2 = {"letra", "4"};
        BadRequestException thrown2 = assertThrows(
                BadRequestException.class,
                () -> imageBitmapService.findOccurrences(invalidString2)
        );

        assertEquals("Elemento c1 não é um número", thrown1.getMessage());
        assertEquals("Elemento letra não é um número", thrown2.getMessage());
    }

}
