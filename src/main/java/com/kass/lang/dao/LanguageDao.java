package com.kass.lang.dao;

import com.kass.lang.domain.Language;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kass on 2017-10-10.
 */
public interface LanguageDao extends CrudRepository<Language, Integer> {

    @Query("SELECT l FROM Language l WHERE l.name = (:name)")
    public Language findByLanguageName(@Param("name") String name);


    @Modifying
    @Transactional
    @Query("delete from Language l where l.name = (:name)")
    public void deleteLanguageByName(@Param("name") String name);
};