package com.example.user.web.controller;

import com.example.core.domain.dto.GetTopicsResponse;
import com.example.core.domain.entity.Topic;
import com.example.core.domain.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping(path = "/topics")
    public Page<?> getTopics(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
        Page<Topic> topics = topicService.findAll(pageable);
        Page<GetTopicsResponse> response = topics
                .map(topic -> new GetTopicsResponse(
                        topic.getName(),
                        topic.getDesc(),
                        topic.getImage()
                ));
        return response;
    }
}
