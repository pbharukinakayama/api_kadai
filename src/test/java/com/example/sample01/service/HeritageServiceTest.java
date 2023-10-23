package com.example.sample01.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.ArgumentMatchers.isA;
// import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.sample01.entity.HeritageEntity;
import com.example.sample01.repository.HeritageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class HeritageServiceTest {

  @Mock
  private HeritageRepository heritageRepository;

  @InjectMocks
  private HeritageService heritageService;

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(heritageService).build();
  }

  @Test
  @DisplayName("全てのデータを参照")
  public void testgetAllHeritages() throws Exception {

    List<HeritageEntity> allHeritagesList = new ArrayList<HeritageEntity>();
    allHeritagesList.add(new HeritageEntity(1, "知床", "北海道", 2005));
    allHeritagesList.add(new HeritageEntity(2, "原爆ドーム", "広島", 1996));
    allHeritagesList.add(new HeritageEntity(3, "屋久島", "鹿児島", 1993));

    // Repositoryの返却値を決める
    when(heritageRepository.findAll()).thenReturn(allHeritagesList);

    // Serviceを呼ぶ 返却値を見る
    List<HeritageEntity> actual = heritageService.getAllHeritages();

    assertEquals(allHeritagesList, actual);

    // Repositoryの呼び出し回数
    verify(heritageRepository, times(1)).findAll();

  }

  @Test
  @DisplayName("特定のデータを参照")
  public void testSelectHeritage() throws Exception {

    Integer heritageId = 1;

    HeritageEntity no1Entity = new HeritageEntity(heritageId, "知床", "北海道", 2005);

    // Repositoryの返却値を決める
    when(heritageRepository.findById(heritageId)).thenReturn(Optional.of(no1Entity));

    // Serviceを呼ぶ 返却値を見る
    Optional<HeritageEntity> actual = heritageService.selectHeritage(heritageId);

    assertEquals(no1Entity, actual.get());

    // Repositoryの呼び出し回数
    verify(heritageRepository, times(1)).findById(heritageId);

  }

  @Test
  @DisplayName("データを登録")
  public void testAddHeritage() throws Exception {

    HeritageEntity no1Entity = new HeritageEntity(1, "知床", "北海道", 2005);

    // Repositoryの返却値を決める
    when(heritageRepository.save(no1Entity)).thenReturn(no1Entity);

    // Serviceを呼ぶ 返却値を見る
    HeritageEntity actual = heritageService.addHeritage(no1Entity);

    assertEquals(no1Entity, actual);

    // Repositoryの呼び出し回数
    verify(heritageRepository, times(1)).save(no1Entity);

  }

  @Test
  @DisplayName("データを更新")
  public void testUpdateHeritage() throws Exception {

    Integer heritageId = 1;

    HeritageEntity no1Entity = new HeritageEntity(heritageId, "知床", "北海道", 2005);

    // Repositoryの返却値を決める
    // when(heritageRepository.save(no1Entity)).thenReturn(no1Entity);
    when(heritageRepository.findById(heritageId)).thenReturn(Optional.of(no1Entity));

    // Serviceを呼ぶ 返却値を見る 戻り値なし！
    heritageService.updateHeritage(heritageId, no1Entity);
    // heritageRepository.findById(heritageId)の返却とをモックして設定

    // Repositoryの呼び出し回数
    verify(heritageRepository, times(1)).save(no1Entity);
  }

  @Test
  @DisplayName("データを削除")
  public void testDeleteHeritage() throws Exception {

    Integer heritageId = 1;

    // HeritageEntity no1Entity = new HeritageEntity(heritageId, "知床", "北海道",2005);

    // Repositoryの返却値を決める 戻り値なし！
    // when(heritageRepository.deleteById(heritageId)).thenReturn(no1Entity);

    // Serviceを呼ぶ 返却値を見る 戻り値なし！
    heritageService.deleteHeritage(heritageId); // こちらは問題なく呼び出せた

    // Repositoryの呼び出し回数
    verify(heritageRepository, times(1)).deleteById(heritageId);

  }

}
