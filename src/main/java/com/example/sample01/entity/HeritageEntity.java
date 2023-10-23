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
@Table(schema = "heritage", name = "heritage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeritageEntity {

  // 遺産ID(主キー)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // キー生成をDBの機能で行う
  @Column(name = "heritage_id", nullable = false)
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
}
