package com.minwoo.sentence.services;

import com.minwoo.sentence.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
    VerbClient verbService;
    SubjectClient subjectService;
    ArticleClient articleService;
    AdjectiveClient adjectiveService;
    NounClient nounService;

    @Autowired
    private WordService wordService;

    @Autowired
    public void setVerbService(VerbClient verbService) {
        this.verbService = verbService;
    }

    @Autowired
    public void setSubjectService(SubjectClient subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setArticleService(ArticleClient articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setAdjectiveService(AdjectiveClient adjectiveService) {
        this.adjectiveService = adjectiveService;
    }

    @Autowired
    public void setNounService(NounClient nounService) {
        this.nounService = nounService;
    }

    @Override
    public String buildSentence() {
        String sentence = "There was a problem assembling the sentence!";
        sentence =
                String.format("%s %s %s %s %s.",
                        subjectService.getWord().getString(),
                        verbService.getWord().getString(),
                        articleService.getWord().getString(),
                        adjectiveService.getWord().getString(),
                        nounService.getWord().getString() );
        return sentence;
    }

    @Override
    public String buildSentenceUsingHystrix() {
        String sentence = "There was a problem assembling the sentence!";
        sentence =
                String.format("%s %s %s %s %s.",
                        wordService.getSubject().getString(),
                        wordService.getVerb().getString(),
                        wordService.getArticle().getString(),
                        wordService.getAdjective().getString(),
                        wordService.getNoun().getString()
                );
        return sentence;
    }
}
