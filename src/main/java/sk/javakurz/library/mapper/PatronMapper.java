package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sk.javakurz.library.dto.PatronDto;
import sk.javakurz.library.dto.PatronFormDataDto;
import sk.javakurz.library.entity.Patron;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PatronMapper {
    public abstract PatronDto patronToPatronDto(Patron patron);

    public abstract List<PatronDto> patronToPatronDto(Iterable<Patron> patron);

    @Mapping(target = "checkouts", ignore = true)
    public abstract Patron patronDtoToPatron(PatronDto patronDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkouts", ignore = true)
    public abstract Patron newPatronDtoToPatron(PatronFormDataDto patronFormDataDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkouts", ignore = true)
    public abstract void updatePatronFromFormPatronDto(@MappingTarget Patron patron, PatronFormDataDto patronFormDataDto);
}
