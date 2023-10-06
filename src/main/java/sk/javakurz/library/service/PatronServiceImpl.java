package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.PatronDto;
import sk.javakurz.library.dto.PatronFormDataDto;
import sk.javakurz.library.exception.ResourceNotFoundException;
import sk.javakurz.library.mapper.PatronMapper;
import sk.javakurz.library.repository.PatronRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PatronServiceImpl implements PatronService {

    private final PatronRepository patronRepository;
    private final PatronMapper patronMapper;

    @Override
    public PatronDto createPatron(PatronFormDataDto patronFormDataDto) {
        var patron = patronMapper.newPatronDtoToPatron(patronFormDataDto);
        var savedPatron = patronRepository.save(patron);
        return patronMapper.patronToPatronDto(savedPatron);
    }

    @Override
    public List<PatronDto> getAllPatrons() {
        var allPatrons = patronRepository.findAll();
        return patronMapper.patronToPatronDto(allPatrons);
    }

    @Override
    public PatronDto findPatronById(Long patronId) {
        var patron = patronRepository.findById(patronId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Čitateľ s ID: " + patronId + " neexistuje!"));
        return patronMapper.patronToPatronDto(patron);
    }

    @Override
    public PatronDto updatePatron(PatronFormDataDto updatedPatron) {
        var patron = patronRepository.findById(updatedPatron.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Čitateľ s ID: " + updatedPatron.getId() + " neexistuje!"));
        patronMapper.updatePatronFromFormPatronDto(patron, updatedPatron);
        var savedPatron = patronRepository.save(patron);
        return patronMapper.patronToPatronDto(savedPatron);
    }

    @Override
    public void deletePatronWithId(Long patronId) {
        patronRepository.deleteById(patronId);
    }
}
