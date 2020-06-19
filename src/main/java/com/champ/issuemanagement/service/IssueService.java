package com.champ.issuemanagement.service;

import com.champ.issuemanagement.dto.IssueDto;
import com.champ.issuemanagement.entity.Issue;
import com.champ.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue); // issue kaydı için parametre aldı.kaydettiği issueyi geri dönderiyor.

    IssueDto getById(Long id); // verdiğimiz id ye göre issue dönderecek.

    TPage<IssueDto> getAllPageable(Pageable pageable); // sayfalama yapıyoruz.

    Boolean delete(Long id);

    IssueDto update(Long id, IssueDto issueDto);
}
