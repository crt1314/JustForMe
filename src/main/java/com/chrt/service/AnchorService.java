package com.chrt.service;

import com.chrt.pojo.Anchor;

import java.util.List;

public interface AnchorService {
    List<Anchor> findByZone(String zone);
}
