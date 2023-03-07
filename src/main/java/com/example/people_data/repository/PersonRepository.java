package com.example.people_data.repository;

import com.example.people_data.model.PeopleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PeopleModel,Long> {

}
