package com.example.sample01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.sample01.entity.HeritageEntity;
import com.example.sample01.service.HeritageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class HeritageControllerTest {

  // Mock化するクラスのインスタンスを生成
  @Mock
  private HeritageService heritageService;

  // モックを注入するクラスのインスタンス生成
  @InjectMocks
  private HeritageController heritageController;

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  // テスト前に行う初期化処理
  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(heritageController).build();
  }

  @Test
  @DisplayName("全てのデータを参照")
  public void testgetAllHeritages() throws Exception {

    List<HeritageEntity> list = Arrays.asList(
        new HeritageEntity(1, "知床", "北海道", 2005),
        new HeritageEntity(2, "原爆ドーム", "広島", 1996),
        new HeritageEntity(3, "屋久島", "鹿児島", 1993));

    // Serviceの返却値を決める
    when(heritageService.getAllHeritages()).thenReturn(list);

    String json = objectMapper.writeValueAsString(list);

    // Controllerのリクエストを実行 レスポンスのテスト
    mockMvc.perform(get("/heritages"))
        .andExpect(status().isOk())
        .andExpect(content().json(json));

    // Serviceの呼び出し回数
    verify(heritageService, times(1)).getAllHeritages();
  }

  @Test
  @DisplayName("特定のデータを参照")
  public void selectHeritage() throws Exception {
    Integer heritageId = 1;

    HeritageEntity no1Entity = new HeritageEntity(heritageId, "知床", "北海道", 2005);

    // Serviceの返却値を決める
    when(heritageService.selectHeritage(1)).thenReturn(Optional.of(no1Entity));

    String json = objectMapper.writeValueAsString(no1Entity);

    // Controllerのリクエストを実行 レスポンスのテスト
    mockMvc.perform(get("/heritage/{heritageId}", heritageId))
        .andExpect(status().isOk())
        .andExpect(content().json(json));

    // Serviceの呼び出し回数
    verify(heritageService, times(1)).selectHeritage(heritageId);
  }

  @Test
  @DisplayName("データを登録")
  public void addHeritage() throws Exception {
    HeritageEntity no1Entity = new HeritageEntity(1, "知床", "北海道", 2005);

    // Serviceの返却値を決める
    when(heritageService.addHeritage(no1Entity)).thenReturn(no1Entity);

    String json = objectMapper.writeValueAsString(no1Entity);

    // Controllerのリクエストを実行 レスポンスのテスト
    mockMvc.perform(post("/heritage")
        .content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());

    // Serviceの呼び出し回数
    verify(heritageService, times(1)).addHeritage(any(HeritageEntity.class));
  }

  @Test
  @DisplayName("データを更新")
  public void updateHeritage() throws Exception {
    Integer heritageId = 1;
    HeritageEntity no1Entity = new HeritageEntity(1, "知床", "北海道", 2005);

    // Serviceの返却値を決める 戻り値なし！
    // when(heritageService.updateHeritage(heritageId,no1Entity)).thenReturn(no1Entity);

    String json = objectMapper.writeValueAsString(no1Entity);

    // Controllerのリクエストを実行 レスポンスのテスト
    mockMvc.perform(put("/heritage/{heritageId}", heritageId)
        .content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());

    // Serviceの呼び出し回数
    verify(heritageService, times(1)).updateHeritage(eq(heritageId), any(HeritageEntity.class));

  }

  @Test
  @DisplayName("データを削除")
  public void deleteHeritage() throws Exception {
    Integer heritageId = 1;
    // HeritageEntity no1Entity = new HeritageEntity(1, "知床", "北海道", 2005);

    // Serviceの返却値を決める 戻り値なし！
    // when(heritageService.deleteHeritage(heritageId)).thenReturn(no1Entity);

    // String json = objectMapper.writeValueAsString(no1Entity);

    // Controllerのリクエストを実行 レスポンスのテスト
    mockMvc.perform(delete("/heritage/{heritageId}", heritageId))
        .andExpect(status().isOk());

    // Serviceの呼び出し回数
    verify(heritageService, times(1)).deleteHeritage(heritageId);
  }

}
