package net.kalangos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import net.kalangos.workshopmongo.domain.Post;
import net.kalangos.workshopmongo.domain.User;
import net.kalangos.workshopmongo.dto.AuthorDTO;
import net.kalangos.workshopmongo.repository.PostRepository;
import net.kalangos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@kalangos.net");
		User alex = new User(null, "Alex Green", "alex@kalangos.net");
		User bob = new User(null, "Bob Grey", "bob@kalangos.net");
		User romildo = new User(null, "Romildo Alves", "romildo@kalangos.net");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, romildo));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
