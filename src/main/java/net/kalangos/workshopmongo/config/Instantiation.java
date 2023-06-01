package net.kalangos.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import net.kalangos.workshopmongo.domain.User;
import net.kalangos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@kalangos.net");
		User alex = new User(null, "Alex Green", "alex@kalangos.net");
		User bob = new User(null, "Bob Grey", "bob@kalangos.net");
		User romildo = new User(null, "Romildo Alves", "romildo@kalangos.net");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, romildo));
		
	}

}
