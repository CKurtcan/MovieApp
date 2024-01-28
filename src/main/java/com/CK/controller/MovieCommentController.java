package com.CK.controller;

import com.CK.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieComment")
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;
}
