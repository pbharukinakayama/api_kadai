package com.example.sample01.repository;

import org.springframework.stereotype.Repository;

import com.example.sample01.entity.HeritageEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HeritageRepository extends JpaRepository<HeritageEntity, Integer> {

}
