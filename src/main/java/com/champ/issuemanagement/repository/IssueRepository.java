package com.champ.issuemanagement.repository;

import com.champ.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {

}
