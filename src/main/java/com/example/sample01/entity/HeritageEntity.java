package com.example.sample01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "heritage")
@Getter
@Setter
@NoArgsConstructor // デフォルトコンストラクタの自動生成 必要？
@AllArgsConstructor // 全フィールドに対する初期化値を引数に取るコンストラクタの生成 必要？
public class HeritageEntity {

  // 遺産ID(主キー)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // キー生成をDBの機能で行う
  private Integer heritageId;

  // 遺産名
  @Column(name = "heritage_name", nullable = false, length = 30)
  private String heritageName;

  // 所在地
  @Column(name = "heritage_location", nullable = false, length = 10)
  private String heritageLocation;

  // 登録年
  @Column(name = "regist_year", nullable = false, length = 4)
  private Integer registYear;

  // // 遺産ID
  // public Integer getId() {
  // return heritageId;
  // }

  // public void setId(Integer heritageId) {
  // this.heritageId = heritageId;
  // }

  // // 遺産名
  // public String getName() {
  // return heritageName;
  // }

  // public void setName(String heritageName) {
  // this.heritageName = heritageName;
  // }

  // // 所在地
  // public String getLocation() {
  // return heritageLocation;
  // }

  // public void setLocation(String heritageLocation) {
  // this.heritageLocation = heritageLocation;
  // }

  // // 登録年
  // public Integer getYear() {
  // return registYear;
  // }

  // public void setYear(Integer registYear) {
  // this.registYear = registYear;
  // }

}
