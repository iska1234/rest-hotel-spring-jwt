package com.example.prueba.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.ClienteEntity;
import com.example.prueba.Entity.PersonalEntity;
import com.example.prueba.Entity.PlanillaTrabajadorEntity;
import com.example.prueba.Entity.RolEntity;
import com.example.prueba.Entity.UserEntity;
import com.example.prueba.Formularios.ClienteDto;
import com.example.prueba.Formularios.PersonalDto;
import com.example.prueba.Model.JWT.CustomUserDetails;
import com.example.prueba.Repository.ClienteRepository;
import com.example.prueba.Repository.PersonalRepository;
import com.example.prueba.Repository.PlanillaTrabajadorRepository;
import com.example.prueba.Repository.RolRepository;
import com.example.prueba.Repository.UserRepository;




@Service
public class UserServiceImpl implements UserService,UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userrepositorio;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private PersonalRepository personalrepository;
	@Autowired
	private PlanillaTrabajadorRepository planillaTrabajadorRepository;
	@Autowired
	private RolRepository rolrepository;

	@Override
	@Transactional(readOnly = true)
	public UserEntity findById(Integer userID) {
		return userrepositorio.findById(userID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userrepositorio.findAll();
	}

	@Override
	public Collection<Object[]> findAll_withUser() {
		// TODO Auto-generated method stub
		return userrepositorio.findAll_withUser();
	}

	@Override
	public UserEntity findByEmail(String email) {
		return userrepositorio.findByEmail(email).orElse(null);
	}

	@Override
	public void crearUsuarioYCliente(ClienteDto clienteDto) {
		UserEntity usuario= new UserEntity();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(clienteDto.getPassword());
		// Asignar Usuario
		usuario.setEmail(clienteDto.getEmail());
		usuario.setPassword(hashedPassword);
		// Asignar el rol de Cliente al usuario
	    RolEntity rol = rolrepository.findByType("USER");
	    usuario.getItemsRole().add(rol);
	    // Guardar el usuario
	    //userrepositorio.save(usuario);
	 // Guardar el usuario
	    UserEntity usuarioGuardado = userrepositorio.save(usuario); 
	 // Crear el Cliente
	    ClienteEntity cliente=new ClienteEntity();
	    cliente.setNombres(clienteDto.getNombres());
	    cliente.setApellidos(clienteDto.getApellidos());
	    cliente.setTelefono(clienteDto.getTelefono());
	    cliente.setDni(clienteDto.getDni());
	    cliente.setUsuario(usuarioGuardado); // <- establecer el usuario recién creado en el cliente
	    clienterepository.save(cliente);
		
	}

	@Override
	public void crearUsuarioYPersonal(PersonalDto personalDto) {
		UserEntity usuario= new UserEntity();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(personalDto.getPassword());
		// Asignar Usuario
		usuario.setEmail(personalDto.getEmail());
		usuario.setPassword(hashedPassword);
		// Asignar el rol de Personal al usuario
	    RolEntity rol = rolrepository.findByType("COLABORADOR");
	    usuario.getItemsRole().add(rol);
	    // Guardar el usuario
	    UserEntity usuarioGuardado =userrepositorio.save(usuario);
	    // Crear el Personal
	    PersonalEntity personal=new PersonalEntity();
	    personal.setCodigo(personalDto.getCodigo());
	    personal.setNombres(personalDto.getNombres());
	    personal.setApellidos(personalDto.getApellidos());
	    personal.setDescripcion(personalDto.getDescripcion());
	    personal.setUsuario(usuarioGuardado);
	    // Guardar el Personal
	    PersonalEntity personalGuardado= personalrepository.save(personal);
	    // Crear Planinalla del personal
	    PlanillaTrabajadorEntity planilla=new PlanillaTrabajadorEntity();
	    planilla.setMonto(personalDto.getMonto());
	    planilla.setTipoTrabajador(personalDto.getTipoTrabajador());
	    planilla.setPersonal(personalGuardado);
	    planillaTrabajadorRepository.save(planilla);
	}

	@Override
	public void save(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRoleToUser(Integer userId, Set<RolEntity> roles) {
		Optional<UserEntity> optionalUser = userrepositorio.findById(userId);
	    if (optionalUser.isPresent()) {
	        UserEntity user = optionalUser.get();
	        user.getItemsRole().addAll(roles);
	        userrepositorio.addRoleToUser(userId, roles);
	    } else {
	        // lanzar una excepción o hacer algo en caso de que el usuario no se encuentre
	    }
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity=this.findByEmail(email);
		
		if(userEntity!=null)
		{
			Collection<GrantedAuthority> authorities=new ArrayList<>();
			
			for(RolEntity roleEntity:userEntity.getItemsRole()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_"+roleEntity.getType()));
			}
			
			User user=new User(email,userEntity.getPassword(),authorities);
			
			return user;
		}
		
		throw new UsernameNotFoundException("¡Password o Email incorectos!");
	}

}
