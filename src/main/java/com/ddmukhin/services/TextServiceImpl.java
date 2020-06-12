package com.ddmukhin.services;

import com.ddmukhin.models.Text;
import com.ddmukhin.repositoriees.TextRepository;

import java.util.List;
import java.util.Optional;

public class TextServiceImpl implements TextService {

    private final TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository){
        this.textRepository = textRepository;
    }

    @Override
    public Optional<Text> findById(Long id) {
        return textRepository.findById(id);
    }

    @Override
    public List<Text> findByTheme(String theme) {
        return
    }

    @Override
    public List<Text> findAll() {
        return null;
    }

    @Override
    public Text saveText(Text text) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteAll() {

    }
}
