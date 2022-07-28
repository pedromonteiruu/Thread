package br.com.usingcache.TrainingCaches.Threads;

import br.com.usingcache.TrainingCaches.Entities.People;
import br.com.usingcache.TrainingCaches.Entities.PeopleList.PeopleList;
import br.com.usingcache.TrainingCaches.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<People> searchPeople(){
        this.Cache = peopleRepository.findAll();
        return this.Cache;
    }

    public List<People> getCache(){
        return Cache;
    }

    public void InstanceRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
        new Thread(this).start();}

    public List<People> findAllPeople(){
        System.out.println("ENTROU FIND ALL GARAI");
        this.InstanceRepository(this.peopleRepository);
        return this.peopleRepository.findAll();}

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                System.out.println("ENTROU NO WHILE");

                if (LocalTime.now().getHour() == 15 && LocalTime.now().getMinute() >= 17) {
                    findAllPeople();
                    searchPeople();

                    System.out.println("CACHE - "+ getCache());
                }
            } catch (Exception e) {
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
