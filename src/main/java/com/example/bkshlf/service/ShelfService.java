package com.example.bkshlf.service;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Shelf;
import com.example.bkshlf.model.User;
import com.example.bkshlf.repository.BookRepository;
import com.example.bkshlf.repository.ShelfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShelfService
{
    private final ShelfRepository shelfRepository;
    private final BookRepository bookRepository;

    public Shelf createShelf(User user, String name)
    {
        Shelf shelf = new Shelf();
        shelf.setIsDefault(false);
        shelf.setUser(user);
        shelf.setName(name);

        String shortname = name.replace(" ", "_");

        long i = 0;
        Optional<Shelf> existingShelf = shelfRepository.findByShortname(shortname);
        while (existingShelf.isPresent()) {
            i++;
            shortname = name.replace(" ", "_") + "_" + i;
            existingShelf = shelfRepository.findByShortname(shortname);
        }

        shelf.setShortname(shortname);
        return shelfRepository.save(shelf);
    }

    public void deleteShelf(Long id, Long userId)
    {
        Shelf shelf = shelfRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Shelf with id " + id + " not found"));

        if (shelf.getIsDefault()) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Cannot delete default shelf");
        } else {
            shelfRepository.deleteById(id);
        }
    }

    public Shelf addBookToShelf(User user, Long shelfId, String bookId)
    {
        Shelf shelf = shelfRepository.findByIdAndUserId(shelfId, user.getId()).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Shelf with id " + shelfId + " not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Book with id " + bookId + " not found"));

        if (!shelf.getBooks().contains(book)) {
            shelf.getBooks().add(book);
        }

        shelfRepository.save(shelf);
        return shelf;
    }
}
