/*
Dicription :- The LoadRepository is a repository interface that interacts with the database to create, read, update, and delete Loads.
 It extends the JpaRepository class provided by Spring Data JPA, which provides a set of common CRUD operations for the Load entity.

The findByShipperId method returns the list of Loads for the given shipperId.

*/

package com.Kapil.LiveasyLogisticAssignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Load, String> {
    List<Load> findByShipperId(String shipperId);
}
/*
ABOUT DATA STORAGE :-
        The data is stored in an in-memory H2 database. H2 is a relational database management system that can be used as an
        embedded database or a server-based database. As it's an in-memory database, the data is stored in memory and not persisted
        to disk. When the application is restarted, all the data will be lost. If you want to persist the data even after restarting
        the application, you can configure H2 to store the data on disk.
        */

