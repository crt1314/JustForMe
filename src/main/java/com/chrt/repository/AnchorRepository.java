package com.chrt.repository;

import com.chrt.pojo.Anchor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnchorRepository extends JpaRepository<Anchor, Integer> {
    List<Anchor> findNameAndUrlAndDescriptionByZone(String zone);
}
