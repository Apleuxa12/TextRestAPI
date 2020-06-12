package com.ddmukhin.services;

import com.ddmukhin.models.Text;

import java.util.List;

public interface TextService {

    Text findById(Long id);

    List<Text> findByTheme(String theme);

    List<Text> findAll();

    Text saveText(Text text);

    void delete();

    void deleteAll();
}
