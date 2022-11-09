package com.trilogyed.musicstorecatalog.controller;

import com.trilogyed.musicstorecatalog.model.Label;
import com.trilogyed.musicstorecatalog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/label")
public class LabelController {
    @Autowired
    LabelRepository repo;

    // create Label
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return repo.save(label);
    }

    // get all Labels
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabels() {
        return repo.findAll();
    }

    // as shown by Dan's heroku-coffee example
    // get Label by ID
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Label getLabelByID(@PathVariable("id") long labelId) {
        Optional<Label> returnVal = repo.findById(labelId);
        if (!returnVal.isPresent()) {
            throw new IllegalArgumentException("No label with id " + labelId);
        }
        return returnVal.get();
    }

    // update Label
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@RequestBody Label label) {
        repo.save(label);
    }

    // delete Label
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable("id") long labelId) {
        repo.deleteById(labelId);
    }
}
