package com.example.core.domain.service;

import com.example.core.domain.entity.Topic;
import com.example.core.domain.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Transactional(readOnly=true)
    public Page<Topic> findAll(Pageable pageable){
        return topicRepository.findAll(pageable);
    }
}
