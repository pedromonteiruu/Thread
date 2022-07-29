package br.com.usingcache.TrainingCaches.Controller;

import br.com.usingcache.TrainingCaches.DTO.PeopleDTO;
import br.com.usingcache.TrainingCaches.Entities.People;
import br.com.usingcache.TrainingCaches.Entities.PeopleList.PeopleList;
import br.com.usingcache.TrainingCaches.Threads.GetThread;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PeopleController {

    @Autowired
    GetThread peopleService;
    public PeopleList peopleList = new PeopleList();

//    @PostConstruct
//    public void iniciarGetThread(){
//        GetThread getThread = new GetThread(this);
//        Thread thread = new Thread(getThread);
//        thread.start();
//    }

//    @GetMapping()
//    @Cacheable("allPeople")
//    @ResponseBody
//    public List<People> findAllPeople(){
//        return peopleService.findAllPeople();
//    }

    @GetMapping("/verusuarios")
    @ResponseBody
    public List<PeopleDTO> getCache(){
        return peopleService.getCache();
    }


}
