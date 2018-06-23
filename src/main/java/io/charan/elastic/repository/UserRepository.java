package io.charan.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import io.charan.elastic.model.User;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
	
    User findByName(String text);

    List<User> findBySalary(Long salary);

	public void deleteByName(String name);
	
	public void updateByName(String name);
	
	
	
	

}
