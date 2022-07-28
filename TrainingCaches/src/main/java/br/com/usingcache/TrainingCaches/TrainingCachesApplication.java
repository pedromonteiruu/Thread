package br.com.usingcache.TrainingCaches;

import br.com.usingcache.TrainingCaches.Threads.GetThread;
import org.hibernate.annotations.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TrainingCachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCachesApplication.class, args);
	}



}
