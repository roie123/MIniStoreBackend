package com.example.MiniStore.SERVICE;

import MODEL.Item;
import com.example.MiniStore.REPO.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {


    @Autowired
    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> getAll(){
        return itemRepo.findAll();
    }

    public Item addNew(Item item){
        item.setActive(true);

        return itemRepo.save(item);
    }

    public Item update(Item item){

        return itemRepo.save(item);
    }
    public void removeItem(String id){
        Item item= itemRepo.findById(id).orElseThrow();
        item.setActive(false);
        itemRepo.save(item);
    }

    public  List<Item> findByCategory(String category){
        List<Item> items = itemRepo.findByCategory(category);
        return items;

    }
    public List<Item> search(String name){
        List<Item> items =itemRepo.findByname(name);
//        itemRepo.findByDesc(name).forEach(items::add);


        return items;
    }

}
