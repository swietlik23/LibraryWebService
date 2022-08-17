package com.swietlicki.library.service;

import com.swietlicki.library.controller.exception.readerException.ReaderEmailTakenException;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.repository.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;
    private ReaderService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ReaderService(readerRepository);
    }

    @Test
    void shouldThrowWhenCannotGetSingleReader() {
        // given
        Reader reader = new Reader();
        // when
        // then
        assertThatThrownBy(() -> underTest.getSingleReader(reader.getId()))
                .isInstanceOf(ReaderNotFoundException.class)
                .hasMessage("Could not find reader with id: " + reader.getId());
    }

    @Test
    void shouldGetSingleReader() {
        // given
        Reader reader = new Reader();
        reader.setId(5);
        // when
        when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        // then
        assertThat(underTest.getSingleReader(reader.getId())).isEqualTo(reader);
    }

    @Test
    void shouldAddReader() {
        // given
        Reader reader = new Reader();
        reader.setFirstName("FirstName");
        reader.setLastName("LastName");
        reader.setEmail("testEmail@test.com");

        // when
        underTest.addReader(reader);

        // then
        ArgumentCaptor<Reader> readerArgumentCaptor = ArgumentCaptor.forClass(Reader.class);

        verify(readerRepository).save(readerArgumentCaptor.capture());

        Reader capturedReader = readerArgumentCaptor.getValue();

        assertThat(capturedReader).isEqualTo(reader);
    }

    @Test
    void shouldThrowWhenEmailIsTaken() {
        // given
        Reader reader = new Reader();
        reader.setFirstName("FirstName");
        reader.setLastName("LastName");
        reader.setEmail("testEmail@test.com");

        given(readerRepository.findByEmail(anyString())).willReturn(reader);

        // when
        // then
        assertThatThrownBy(() -> underTest.addReader(reader))
                .isInstanceOf(ReaderEmailTakenException.class)
                .hasMessageContaining("Email " + reader.getEmail() + " taken");

        verify(readerRepository, never()).save(any());

    }

    @Test
    void shouldUpdateReader() {
        Reader readerToUpdate = new Reader();
        Reader readerUpdateDetails = new Reader();
        readerUpdateDetails.setFirstName("FirstName");
        readerUpdateDetails.setLastName("LastName");
        readerUpdateDetails.setEmail("testEmail@test.com");


        given(readerRepository.findById(readerToUpdate.getId())).willReturn(Optional.of(readerToUpdate));

        // when
        underTest.updateReader(readerUpdateDetails);

        // then
        ArgumentCaptor<Reader> readerArgumentCaptor = ArgumentCaptor.forClass(Reader.class);

        verify(readerRepository).save(readerArgumentCaptor.capture());

        Reader capturedReader = readerArgumentCaptor.getValue();

        assertThat(capturedReader).extracting("id", "firstName", "lastName", "email")
                .containsExactly(readerToUpdate.getId(),
                        readerUpdateDetails.getFirstName(),
                        readerUpdateDetails.getLastName(),
                        readerUpdateDetails.getEmail());
    }

    @Test
    void shouldNotUpdateReader() {
        // given
        Reader reader = new Reader();

        // when
        // then
        assertThatThrownBy(() -> underTest.updateReader(reader))
                .isInstanceOf(ReaderNotFoundException.class)
                .hasMessageContaining("Could not find reader with id: " + reader.getId());

        verify(readerRepository, never()).save(any());
    }

    @Test
    void shouldDeleteReader() {

        // given
        Reader reader = new Reader();

        given(readerRepository.existsById(reader.getId())).willReturn(true);

        // when
        underTest.deleteReader(reader.getId());

        // then
        ArgumentCaptor<Long> readerIdArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        verify(readerRepository).deleteById(readerIdArgumentCaptor.capture());

        long capturedReaderId = readerIdArgumentCaptor.getValue();

        assertThat(capturedReaderId).isEqualTo(reader.getId());

    }

    @Test
    void shouldNotDeleteReader() {

        // given
        Reader reader = new Reader();

        given(readerRepository.existsById(reader.getId())).willReturn(false);

        // when
        // then
        assertThatThrownBy(() -> underTest.deleteReader(reader.getId()))
                .isInstanceOf(ReaderNotFoundException.class)
                .hasMessageContaining("Could not find reader with id: " + reader.getId());

        verify(readerRepository, never()).deleteById(any());

    }

    @Test
    void updateReaderBalance() {

        // given
        Reader readerToUpdate = mock(Reader.class);
        readerToUpdate.setId(5);
        given(readerRepository.findById(readerToUpdate.getId())).willReturn(Optional.of(readerToUpdate));
        // when
        doNothing().when(readerToUpdate).setCurrentBalance();
        underTest.updateReaderBalance(readerToUpdate.getId());

        // then

        ArgumentCaptor<Reader> readerArgumentCaptor = ArgumentCaptor.forClass(Reader.class);

        verify(readerRepository).save(readerArgumentCaptor.capture());

        Reader capturedReader = readerArgumentCaptor.getValue();

        assertThat(capturedReader.getId()).isEqualTo(readerToUpdate.getId());

    }

    @Test
    void shouldNotUpdateReaderBalance() {

        // given
        Reader readerToUpdate = new Reader();
        // when
        when(readerRepository.findById(readerToUpdate.getId())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> underTest.updateReaderBalance(readerToUpdate.getId()))
                .isInstanceOf(ReaderNotFoundException.class)
                .hasMessageContaining("Could not find reader with id: " + readerToUpdate.getId());

        verify(readerRepository, never()).save(any());
    }
}