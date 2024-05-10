package com.example.bkshlf.service;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.UserBook;
import com.example.bkshlf.repository.UserBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBookService
{
    private final LibraryService libraryService;
    private final UserBookRepository userBookRepository;

    public Boolean attachBookToUser(long userId, String bookId, long editionId)
    {
        Book book = libraryService.getBookWithEdition(bookId, editionId);
        if (book == null) {
            return false;
        }

        UserBook userBook = new UserBook();
        userBook.setBookId(bookId);
        userBook.setUserId(userId);
        userBook.setEditionId(editionId);
        userBookRepository.save(userBook);
        return true;
    }
}
