package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.Client;
import com.example.demo.models.Rental;
import com.example.demo.services.HomeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HomeController {

    @Autowired
    HomeSerivce homeSerivce;

    //Books
    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        return new ResponseEntity<>(homeSerivce.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return homeSerivce.getAllBooks();
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
        homeSerivce.addBook(book);
    }

    @PutMapping("/updateBook")
    public  void updateBook(@RequestBody Book book){
        homeSerivce.updateBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Integer id){
        homeSerivce.deleteBook(id);
    }



    //ComicBooks
    @GetMapping("/getAllComicBooks")
    public List<Book> getAllComicBooks(){
        return homeSerivce.getAllComicBooks();
    }
    @GetMapping("/getComicBook/{id}")
    public ResponseEntity<Book> getComicBook(@PathVariable Integer id){
        return new ResponseEntity<>(homeSerivce.getComicBook(id),HttpStatus.OK);
    }
    @PostMapping("/addComicBook")
    public void addComicBook(@RequestBody Book book){
        homeSerivce.addBook(book);
    }
    @PutMapping("/updateComicBook")
    public  void updateComicBook(@RequestBody Book book){
        homeSerivce.updateBook(book);
    }
    @DeleteMapping("/deleteComicBook/{id}")
    public void deleteComicBook(@PathVariable Integer id){
        homeSerivce.deleteComicBook(id);
    }



    //Client
    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return homeSerivce.getAllClients();
    }

    @GetMapping("/getClient/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id){
        return new ResponseEntity<>(homeSerivce.getClient(id),HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client){
        homeSerivce.addClient(client);
    }

    @PutMapping("/updateClient")
    public void updateClient(@RequestBody Client client){
        homeSerivce.updateClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Integer id){
        homeSerivce.deleteClient(id);
    }

    //Rental
    @PostMapping("/rentABook/client/{clientId}/book/{bookId}")
    public void rentABook(@PathVariable Integer clientId, @PathVariable Integer bookId) {
        homeSerivce.rentABook(clientId,bookId);
    }

    @PostMapping("/returnABook/rentalId/{rentalId}")
    public void returnABook(@PathVariable Integer rentalId){
        homeSerivce.returnABook(rentalId);
    }

    @GetMapping("/getAllRentals")
    public List<Rental> getAllRentals(){
        return homeSerivce.getAllRentals();
    }

    //Search
    @GetMapping("/search/books/title")
    public ResponseEntity<List<Book>> getBooksByName(@RequestParam String title){
        return new ResponseEntity<List<Book>>(homeSerivce.getBooksByName(title),HttpStatus.OK);
    }

    @GetMapping("/search/books/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        return new ResponseEntity<List<Book>>(homeSerivce.getBooksByAuthor(author),HttpStatus.OK);
    }
    @GetMapping("/search/comicBooks/series")
    public ResponseEntity<List<Book>> getComicBooksByseries(@RequestParam Integer series){
        return new ResponseEntity<List<Book>>(homeSerivce.getComicBooksByseries(series),HttpStatus.OK);
    }

    @GetMapping("/search/comicBooks/number")
    public ResponseEntity<List<Book>> getComicBooksByNumber(@RequestParam Integer number){
        return new ResponseEntity<List<Book>>(homeSerivce.getComicBooksNumber(number),HttpStatus.OK);
    }

    @GetMapping("/search/comicBooks/seriesAndNumber")
    public ResponseEntity<List<Book>> getComicBooksByseriesAndNumber(@RequestParam Integer series , @RequestParam Integer number){
        return new ResponseEntity<List<Book>>(homeSerivce.getComicBooksByseriesAndNumber(series , number),HttpStatus.OK);
    }

    @GetMapping("/search/client/idAndName")
    public ResponseEntity<List<Client>> getClientByIdAndName(@RequestParam Integer id, @RequestParam String name){
        return new ResponseEntity<List<Client>>(homeSerivce.getClientByIdAndName(id,name),HttpStatus.OK);
    }

    @GetMapping("/search/client/id")
    public ResponseEntity<List<Client>> getClientById(@RequestParam Integer id){
        return new ResponseEntity<List<Client>>(homeSerivce.getClientById(id),HttpStatus.OK);
    }

    @GetMapping("/search/client/name")
    public ResponseEntity<List<Client>> getClientByName(@RequestParam String name){
        return new ResponseEntity<List<Client>>(homeSerivce.getClientByName(name),HttpStatus.OK);
    }

    //Sorting
    @GetMapping("/sort/client/name")
    public List<Client> sortByName(){
        return homeSerivce.sortByName();
    }

    @GetMapping("/sort/client/id")
    public List<Client> sortById(){
        return homeSerivce.sortById();
    }

    @GetMapping("/sort/books/title")
    public List<Book> sortByTitle(){
        return homeSerivce.sortByTitle();
    }

    @GetMapping("/sort/books/author")
    public List<Book> sortByAuthor(){
        return homeSerivce.sortByAuthor();
    }

    @GetMapping("/sort/books/title&author")
    public List<Book> sortByTitleAndAuthor(){
        return homeSerivce.sortByTitleAndAuthor();
    }

    @GetMapping("/sort/comics/name&series&number")
    public List<Book> sortByNameAndSeriesAndNumber(){
        return  homeSerivce.sortByNameAndSeriesAndNumber();
    }

    @GetMapping("/sort/comics/series&number")
    public List<Book> sortBySeriesAndNumber(){
        return  homeSerivce.sortBySeriesAndNumber();
    }

}
