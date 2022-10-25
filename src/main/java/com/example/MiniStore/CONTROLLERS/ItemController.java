package com.example.MiniStore.CONTROLLERS;

import MODEL.Item;
import com.example.MiniStore.SERVICE.ItemService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;

    }

    @GetMapping(path = "/all")
    public List<Item> getAll(){
        List<Item> items =itemService.getAll();
        return items;
    }
    @GetMapping(path = "/find/{category}")
    public List<Item> findByCategory(@PathVariable("category")String category){
        List<Item> items = itemService.findByCategory(category);
        return items;
    }
    @GetMapping(path = "/find_by_name/{name}")
    public List<Item> SearchEngine(@PathVariable("name")String name){
        List<Item> items = itemService.search(name);
        return items;
    }
    @PostMapping(path = "/add")
    public Item addNew(@RequestBody Item item){
        Item item1 = itemService.addNew(item);
        return item1;

    }
    @PutMapping(path = "/update")
    public Item updateItem(@RequestBody Item item){
        return itemService.update(item);

    }

    @PutMapping(path = "/remove")
    public void remove(@PathVariable("id") String id){
        itemService.removeItem(id);

    }



    @PostMapping(path = "/admin")
    public ResponseEntity getAdmin(@RequestBody Item item){
        Item item1=new Item();
        System.out.println(item.getName());
        System.out.println(item.getDesc());
        if (Objects.equals(item.getName(), "admin") && Objects.equals(item.getDesc(), "admin")){
            item1.setName("true");
            return new ResponseEntity(item1,HttpStatus.OK);
        }
        else {
            item.setName("NO");
            return new ResponseEntity<Item>(item,HttpStatus.BAD_REQUEST);
        }
    }

}
