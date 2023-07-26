package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import sk.javakurz.library.dto.PatronDto;
import sk.javakurz.library.entity.Patron;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatronMapper {
    PatronDto patronToPatronDto(Patron patron);

    List<PatronDto> patronToPatronDto(Iterable<Patron> patron);

    Patron patronDtoToPatron(PatronDto patronDto);

    List<Patron> patronDtoToPatron(Iterable<PatronDto> patronDto);
}
