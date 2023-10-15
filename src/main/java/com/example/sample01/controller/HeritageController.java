package com.example.sample01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample01.entity.HeritageEntity;
import com.example.sample01.exception.HeritageNotFoundException;
import com.example.sample01.service.HeritageService;

@RestController
public class HeritageController {

  @Autowired
  private HeritageService heritageService;

  // 全てのデータを参照
  @GetMapping("/heritages")
  public List<HeritageEntity> getAllHeritages() {
    return heritageService.getAllHeritages();
  }

  // 特定のデータを参照
  @GetMapping("/heritage/{heritageId}")
  public HeritageEntity selectHeritage(@PathVariable("heritageId") Integer heritageId) {
    return heritageService.selectHeritage(heritageId).orElseThrow(() -> new HeritageNotFoundException(heritageId));
  }

  // データを登録
  @PostMapping("/heritage")
  public void addHeritage(@RequestBody HeritageEntity heritageEntity) {
    heritageService.addHeritage(heritageEntity);
  }

  // データを更新
  @PutMapping("/heritage/{heritageId}")
  public void updateHeritage(@RequestBody HeritageEntity heritageEntity,
      @PathVariable("heritageId") Integer heritageId) {
    heritageService.updateHeritage(heritageId, heritageEntity);
  }

  // データを削除
  @DeleteMapping("/heritage/{heritageId}")
  public void deleteHeritage(@PathVariable("heritageId") Integer heritageId) {
    heritageService.deleteHeritage(heritageId);
  }

}
