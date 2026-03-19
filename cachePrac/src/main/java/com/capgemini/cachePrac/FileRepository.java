package com.capgemini.cachePrac;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileData, Integer> {

}
