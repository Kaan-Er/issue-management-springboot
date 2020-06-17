package com.champ.issuemanagement.service;

import com.champ.issuemanagement.entity.Issue;
import com.champ.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistory save(IssueHistory issueHistory); // issue kaydı için parametre aldı.kaydettiği issueyi geri dönderiyor.

    IssueHistory getById(Long id); // verdiğimiz id ye göre issue dönderecek.

    Page<IssueHistory> getAllPageable(Pageable pageable); // sayfalama yapıyoruz.

    Boolean delete(IssueHistory issueHistory); // silme işlemi.
}
