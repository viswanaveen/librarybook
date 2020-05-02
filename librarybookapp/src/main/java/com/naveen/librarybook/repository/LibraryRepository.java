package com.naveen.librarybook.repository;

import com.naveen.librarybook.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
