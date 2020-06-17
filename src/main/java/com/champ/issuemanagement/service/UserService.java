package com.champ.issuemanagement.service;

import com.champ.issuemanagement.entity.Issue;
import com.champ.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user); // issue kaydı için parametre aldı.kaydettiği issueyi geri dönderiyor.

    User getById(Long id); // verdiğimiz id ye göre issue dönderecek.

    Page<User> getAllPageable(Pageable pageable); // sayfalama yapıyoruz.

    User getByUsername(String username);
}
