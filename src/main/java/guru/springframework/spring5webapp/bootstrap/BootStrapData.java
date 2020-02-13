package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		Publisher asto = new Publisher("13st N.E.","Calgary", "AB", "T2E4R8");
		publisherRepository.save(asto);
		
		ddd.setPublisher(asto);
		asto.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(asto);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Devel;opment without EJB", "393459459");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(asto);
		asto.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(asto);
	
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		System.out.println("Publisher Number of Books: " + asto.getBooks().size());
		
	}
 
 
	
}
