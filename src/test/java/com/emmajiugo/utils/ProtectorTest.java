package com.emmajiugo.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ProtectorTest {
    private static List<String> words;

    @BeforeAll
    static void init() {
        words = Protector.readWordsFromFile();
    }

    @Test
    void testFindAnagramWords() {
        Map<String, List<String>> anagramWords = Protector.findAnagramWords(words);

        assertThat(anagramWords.isEmpty()).isFalse();
        assertThat(anagramWords.containsKey("at")).isTrue();
    }

    @Test
    void testFindAnagramWordsException() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Protector.findAnagramWords(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Protector.findAnagramWords(List.of()));
    }

    @Test
    void testReadWordsFromFile() {

        assertThat(words.size()).isGreaterThan(0);
    }
}