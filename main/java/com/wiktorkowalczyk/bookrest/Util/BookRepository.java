package com.wiktorkowalczyk.bookrest.Util;

import com.wiktorkowalczyk.bookrest.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
}
