package com.example.MiniStore.REPO;

import MODEL.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends MongoRepository<Item,String> {
    public List<Item> findByCategory(String category);
    public  List<Item> findByname(String name);
    public List<Item> findByDesc(String desc);
}
