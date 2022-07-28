package br.com.usingcache.TrainingCaches.Entities.PeopleList;

import br.com.usingcache.TrainingCaches.Entities.People;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeopleList {
    private List<People> allPeople;
}
