package com.kass.lang.service;

import com.kass.lang.domain.Language;

import java.util.List;

/**
 * Created by kass on 2017-10-10.
 */
public interface LanguageService {
    Iterable<Language> getAllLanguages();
    void addLanguage(Language lang);
    Language getLanguage(int id);
    void deleteLanguage(int id);
    void updateLanguage(Language lang);
    Language findByLanguageName(String name);
    void deleteLanguageByName(String name);

}
