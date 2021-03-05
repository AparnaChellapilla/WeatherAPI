package com.tts.WeatherAPI.repository;

import com.tts.WeatherAPI.model.ZipCode;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ZipCodeRepository extends PagingAndSortingRepository<ZipCode, Long> {

}

