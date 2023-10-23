package com.example.sample01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample01.entity.HeritageEntity;
import com.example.sample01.repository.HeritageRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HeritageService {

  @Autowired
  public HeritageRepository heritageRepository;

  // 全てのデータを参照
  public List<HeritageEntity> getAllHeritages() {
    List<HeritageEntity> allHeritages = new ArrayList<>();
    heritageRepository.findAll().forEach(allHeritages::add);

    return allHeritages;
  }

  // 特定のデータを参照
  public Optional<HeritageEntity> selectHeritage(Integer heritageId) {
    return heritageRepository.findById(heritageId);
  }

  // データを登録
  public HeritageEntity addHeritage(HeritageEntity heritageEntity) {
    return heritageRepository.save(heritageEntity);
  }

  // データを更新
  public void updateHeritage(Integer heritageId, HeritageEntity heritageEntity) {
    if (heritageRepository.findById(heritageId).get() != null) {
      heritageRepository.save(heritageEntity);
    }
  }

  // データを削除
  public void deleteHeritage(Integer heritageId) {
    heritageRepository.deleteById(heritageId);
  }

}
