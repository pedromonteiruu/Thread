package br.com.usingcache.TrainingCaches.Threads;

import br.com.usingcache.TrainingCaches.Controller.PeopleController;
import br.com.usingcache.TrainingCaches.DTO.PeopleDTO;
import br.com.usingcache.TrainingCaches.Entities.People;
import br.com.usingcache.TrainingCaches.Entities.PeopleList.PeopleList;
import br.com.usingcache.TrainingCaches.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetThread implements Runnable{

    @Autowired
    public PeopleRepository peopleRepository ;
    private List<People> Cache;
    private List<PeopleDTO> CacheDTO;

    public List<People> searchPeople(){
        this.Cache = peopleRepository.findAll();
        this.CacheDTO = convertToDTO(Cache);
        return this.Cache;
    }

    public List<PeopleDTO> getCache(){
        new Thread(this).start();
        return CacheDTO;
    }

    private List<PeopleDTO> convertToDTO(List<People> listaPessoinhas){
        List<PeopleDTO> listaPessoaDTO = new ArrayList<>();
        for(People people : listaPessoinhas){
            listaPessoaDTO.add(PeopleDTO.newPeopleDto(people));
        }
        return listaPessoaDTO;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(60000);
                System.out.println("SALVE - SALVE ");
                if (LocalTime.now().getHour() == 8 && LocalTime.now().getMinute() == 00) {
//                    findAllPeople();
                    searchPeople();
                }
            } catch (Exception e) {
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
