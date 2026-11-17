
package com.example.tourist.service;

import java.util.List;
import com.example.tourist.entity.Tourist;

public interface TouristService {

    List<Tourist> getAllTourists(String token);

}
