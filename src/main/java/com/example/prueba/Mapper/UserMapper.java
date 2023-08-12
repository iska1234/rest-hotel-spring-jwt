package com.example.prueba.Mapper;

import com.example.prueba.Entity.RolEntity;
import com.example.prueba.Entity.UserEntity;

public class UserMapper {
	private Integer userId;
    private String email;
    private String roleType;

    public UserMapper(Integer userId, String email, String roleType) {
        this.userId = userId;
        
        this.email = email;
        this.roleType = roleType;
    }
    public static UserMapper mapToUserMapper(UserEntity userEntity) {
        return new UserMapper(userEntity.getUsuarioID(), 
        		userEntity.getEmail(),
        		userEntity.getItemsRole().stream().findFirst().map(RolEntity::getType).orElse(null));
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}
