package com.ddmukhin.main.controllers;

import com.ddmukhin.main.models.Text;
import com.ddmukhin.main.repositories.TextRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class TextController {

    private final TextRepository textRepository;

    public TextController(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Text> getTextById(@PathVariable(name = "id") Long id){

        Optional<Text> textHolder = textRepository.findById(id);

        if(textHolder.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(textHolder.get(), HttpStatus.OK);
    }

    @GetMapping("/texts")
    public ResponseEntity<List<Text>> readAll(){
        return new ResponseEntity<>(textRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<Text> getRandomText(){
        List<Text> texts = textRepository.findAll();
        Text rndText = texts.get(ThreadLocalRandom.current().nextInt(texts.size()));
        return new ResponseEntity<>(rndText, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveText(@RequestBody Text text){
        textRepository.save(text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteText(@PathVariable(name = "id") Long id){
        textRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
