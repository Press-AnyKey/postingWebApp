package com.example.webapptest.repository;

import com.example.webapptest.model.PostingItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingItemRepository extends CrudRepository<PostingItem, Integer>{
}
