package com.example.interview.controller.impl;

import com.example.interview.controller.ImageBitmapController;
import com.example.interview.service.ImageBitmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/imageBitmap")
public class ImageBitmapControllerImpl implements ImageBitmapController {

    private final ImageBitmapService imageBitmapService;

    @Override
    @GetMapping("/getOccurrences/{elements}")
    public String findOccurrences(@PathVariable String[] elements) {
        try {
            return imageBitmapService.findOccurrences(elements);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
