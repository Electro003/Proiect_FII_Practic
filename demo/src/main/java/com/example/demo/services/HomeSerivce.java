package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Client;
import com.example.demo.models.Rental;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.ClientsRepository;
import com.example.demo.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class HomeSerivce {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    ClientsRepository clientsRepository;
    @Autowired
    RentalRepository rentalRepository;

    //Book
    public Book getBook(Integer id) { return bookRepository.findById(id).get(); }

    public List<Book> getAllBooks() {
        List<Book> list1 = bookRepository.findAll();
        for(int i=0 ; i<list1.size();i++){
            if(list1.get(i).getSeries()!=null) {
                list1.remove(i);
                i--;
            }

        }
        return list1;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }


    //Client
    public List<Client> getAllClients() { return clientsRepository.findAll(); }

    public void addClient(Client client) { clientsRepository.save(client); }

    public Client getClient(Integer id) { return clientsRepository.findById(id).get(); }

    public void updateClient(Client client) { clientsRepository.save(client); }

    public void deleteClient(Integer id) { clientsRepository.deleteById(id); }


    //Comics
    public List<Book> getAllComicBooks() {
        List<Book> list1 = bookRepository.findAll();
        for(int i=0 ; i<list1.size();i++){
            if(list1.get(i).getSeries()==null && list1.get(i).getNumber()==null) {
                list1.remove(i);
                i--;
            }
        }
        return list1;
    }

    public Book getComicBook(Integer id) {
        Book return_book = new Book();
        List<Book> list = getAllComicBooks();
        for(Book book : list) {
            if (book.getId() == id)
                return_book = book;
        }
        if(return_book.getId()==null)
            return null;
        else return return_book;
    }

    public void deleteComicBook(Integer id) {
        Book return_book = new Book();
        List<Book> list = getAllComicBooks();
        for(Book book : list) {
            if (book.getId() == id)
                return_book = book;
        }
        if(return_book.getId()!=null)
            bookRepository.deleteById(id);
    }

    //RentService

    public void rentABook(Integer clientId, Integer bookId) {
        boolean flag_client=false , flag_book=false;
        if(clientsRepository.existsById(clientId))
            flag_client=true;
        if(bookRepository.existsById(bookId))
            flag_book=true;
        if(flag_book && flag_client){
            Date currentDate = new Date();
            Random rn = new Random();
            Integer n = 1000001;
            Integer random = rn.nextInt()%n;
            if(random<=0)
                random*=-1;

            Rental rental = new Rental(random,clientId,bookId,currentDate,null);
            rentalRepository.save(rental);}
    }

    public void returnABook(Integer rentalId) {
        Date returnDate = new Date();
        if(rentalRepository.existsById(rentalId)){
            System.out.println(returnDate);
            Rental newRental  = rentalRepository.getById(rentalId);
            newRental.setReturned_date((returnDate));
            rentalRepository.save(newRental);
        }
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }



    public List<Book> getBooksByName(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getComicBooksByseriesAndNumber(Integer series, Integer number) {
        return bookRepository.findBySeriesAndNumber(series,number);
    }

    public List<Book> getComicBooksByseries(Integer series) {
        return bookRepository.findBySeries(series);
    }

    public List<Book> getComicBooksNumber(Integer number) {
        return bookRepository.findByNumber(number);
    }

    public List<Client> getClientByIdAndName(Integer id, String name) {
        return clientsRepository.findClientsByIdAndName(id,name);
    }

    public List<Client> getClientById(Integer id) {
        return clientsRepository.findClientById(id);
    }

    public List<Client> getClientByName(String name) {
        return clientsRepository.findClientsByName(name);
    }

    public List<Client> sortByName() {
        return clientsRepository.findAll(Sort.by("name"));
    }

    public List<Client> sortById() {
        return clientsRepository.findAll(Sort.by("id"));
    }

    public List<Book> sortByTitleAndAuthor() {
        return bookRepository.findAll(Sort.by("title","author"));
    }

    public List<Book> sortBySeriesAndNumber() {
        return bookRepository.findAll(Sort.by("series").and(Sort.by("number").descending()));
    }

    public List<Book> sortByTitle() {
        return bookRepository.findAll(Sort.by("title"));
    }

    public List<Book> sortByAuthor() {
        return bookRepository.findAll(Sort.by("author"));
    }

    public List<Book> sortByNameAndSeriesAndNumber() {
        return  bookRepository.findAll(Sort.by("title").and(Sort.by("series").and(Sort.by("number").descending())));
    }


    public void allBookClient() {
    }
}


