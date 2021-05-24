package com.socialnetwork.services;

import com.socialnetwork.domain.UnhealthyWord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnhealthyWordService {
    void removeWord(String word);

    boolean wordExists(String word);

    void addWord(String word);

    void deleteWord(String word);

    List<UnhealthyWord> getUnhealthyWordList();
}
