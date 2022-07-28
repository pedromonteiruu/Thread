package br.com.usingcache.TrainingCaches.Controller;

import br.com.usingcache.TrainingCaches.Entities.People;
import br.com.usingcache.TrainingCaches.Entities.PeopleList.PeopleList;
import br.com.usingcache.TrainingCaches.Threads.GetThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PeopleController {

    @Autowired
    GetThread peopleService;
    public PeopleList peopleList = new PeopleList();

    @GetMapping()
    @Cacheable("allPeople")
    @ResponseBody
    public List<People> findAllPeople(){
        List<People> todasPessoas = peopleService.findAllPeople();
        peopleList.setAllPeople(todasPessoas);
        System.out.println(peopleList.getAllPeople() + " todas pessoas nesse caralho");
        return peopleService.findAllPeople();
    }

    @GetMapping("/verusuarios")
    @ResponseBody
    public List<People> getCache(){
        return peopleService.getCache();
    }

    


}
