package com.erendarici.repository;

import com.erendarici.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"firstname\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);

    List<Person> findByFirstnameLikeOrLastnameLike(String firstname, String lastname);
}
