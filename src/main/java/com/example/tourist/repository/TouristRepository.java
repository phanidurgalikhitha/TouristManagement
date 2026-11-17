
package com.example.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tourist.entity.Tourist;

@Repository
public interface TouristRepository
        extends JpaRepository<Tourist, Integer> {

}
