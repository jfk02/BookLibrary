package sk.javakurz.library.service;

import sk.javakurz.library.dto.PatronDto;
import sk.javakurz.library.dto.PatronFormDataDto;

import java.util.List;

public interface PatronService {

    PatronDto createPatron(PatronFormDataDto patronFormDataDto);

    List<PatronDto> getAllPatrons();

    PatronDto findPatronById(Long patronId);

    PatronDto updatePatron(PatronFormDataDto updatedPatron);

    void deletePatronWithId(Long patronId);
}
