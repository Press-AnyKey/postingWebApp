package com.example.webapptest.controller;

import com.example.webapptest.model.Posting;
import com.example.webapptest.repository.PostingRepository;
import com.example.webapptest.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posting")
public class PostingController {
    @Autowired
    private PostingService postingService;

    @GetMapping(value = "/{id}")
    public Posting getPosting(@PathVariable long id) {
        return postingService.findPostingById(id);
    }

    @GetMapping(value = "/year/{year}")
    public List<Posting> getPosting(@PathVariable int year, @RequestParam(required = false, name = "authorized") Boolean auth) {
        if(auth != null){
            return postingService.findPostingByYearAndAuth(year, auth);
        }
        else{
            return postingService.findPostingByYear(year);
        }
    }

    @DeleteMapping
    public void deletePosting() {
        postingService.deleteAll();
    }


}
