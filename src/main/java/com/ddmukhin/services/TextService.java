package com.ddmukhin.services;

import com.ddmukhin.models.Text;

import java.util.List;
import java.util.Optional;

public interface TextService {

    Optional<Text> findById(Long id);

    List<Text> findByTheme(String theme);

    List<Text> findAll();

    Text saveText(Text text);

    void delete();

    void deleteAll();
}
