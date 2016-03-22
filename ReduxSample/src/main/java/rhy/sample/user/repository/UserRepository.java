package rhy.sample.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import rhy.sample.user.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, String>{

    
}
