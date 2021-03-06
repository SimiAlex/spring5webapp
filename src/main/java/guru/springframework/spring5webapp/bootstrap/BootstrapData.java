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
public class BootstrapData implements CommandLineRunner {

    //fields
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //constructor
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    //overridden methods
    @Override
    public void run(String... args) throws Exception {

        Publisher nemira = new Publisher("Nemira", "Strada Gura Vadului, 4");
        publisherRepository.save(nemira);
        Author otilia = new Author("Otilia", "Cazimir");
        Book unchiulDinAmerica = new Book("Unchiul din America", "122");
        
        otilia.getBooks().add(unchiulDinAmerica);
        unchiulDinAmerica.getAuthors().add(otilia);
        unchiulDinAmerica.setPublisher(nemira);
        nemira.getBooks().add(unchiulDinAmerica);

        authorRepository.save(otilia);
        bookRepository.save(unchiulDinAmerica);
        

        Publisher polirom = new Publisher("Polirom", "Strada Bacaniei, 5");
        publisherRepository.save(polirom);
        Author nichita = new Author("Nichita", "Stanescu");
        Book alfa = new Book("Alfa", "1967");
       
        nichita.getBooks().add(alfa);
        alfa.getAuthors().add(nichita);
        alfa.setPublisher(polirom);
        polirom.getBooks().add(alfa);
        

        authorRepository.save(nichita);
        bookRepository.save(alfa);
        
        

        System.out.println("Started in bootstrap");
        System.out.println("Books added to database: " + bookRepository.count());
        System.out.println("Publishers added: " + publisherRepository.count());
    }
    
}
