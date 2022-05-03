package com.chrt.service.impl;

import com.chrt.pojo.Anchor;
import com.chrt.repository.AnchorRepository;
import com.chrt.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnchorServiceImpl implements AnchorService {

    @Autowired
    private AnchorRepository anchorRepository;

    @Override
    public List<Anchor> findByZone(String zone) {
        return anchorRepository.findNameAndUrlAndDescriptionByZone(zone);
    }
}
