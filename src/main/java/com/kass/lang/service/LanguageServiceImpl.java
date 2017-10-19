package com.kass.lang.service;

import com.kass.lang.dao.LanguageDao;
import com.kass.lang.domain.Language;
import groovy.lang.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kass on 2017-10-10.
 */
@Service
@Singleton
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageDao langDao;

    @Override
    public Iterable<Language> getAllLanguages() {
        return langDao.findAll();
    }

    @Override
    public void addLanguage(Language lang){
        langDao.save(lang);
    }

    @Override
    public Language getLanguage(int id) {
        return langDao.findOne(id);
    }

    @Override
    public void deleteLanguage(int id) {
        langDao.delete(id);
    }

    @Override
    public void updateLanguage(Language lang) {
        langDao.save(lang);
    }

    @Override
    public Language findByLanguageName(String name) {
        return langDao.findByLanguageName(name);
    }

    @Override
    public void deleteLanguageByName(String name) {
        langDao.deleteLanguageByName(name);
    }
}
