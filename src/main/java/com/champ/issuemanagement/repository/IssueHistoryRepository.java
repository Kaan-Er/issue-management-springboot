package com.champ.issuemanagement.repository;

import com.champ.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

}
