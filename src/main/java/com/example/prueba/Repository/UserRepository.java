package com.example.prueba.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.prueba.Entity.RolEntity;
import com.example.prueba.Entity.UserEntity;





public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query(value="select usr.usuarioID,usr.email as 'Email',rl.rolid,rl.type as 'Nombre' from users_roles ur \r\n"
	        +"inner join usuario usr on ur.user_id=usr.userid \r\n"
	        +"inner join rol rl on ur.role_id=rl.rolid order by usr.userid;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withUser();	
	Optional<UserEntity> findByEmail(String email);
	@Modifying
	@Query("UPDATE UserEntity u SET u.itemsRole = :roles WHERE u.usuarioID = :userId")
	void addRoleToUser(@Param("userId") Integer userId, @Param("roles") Set<RolEntity> roles);

}
