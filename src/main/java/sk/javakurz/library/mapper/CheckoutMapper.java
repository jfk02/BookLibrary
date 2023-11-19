package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sk.javakurz.library.dto.CheckoutDto;
import sk.javakurz.library.dto.CheckoutFormDataDto;
import sk.javakurz.library.entity.Checkout;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CheckoutMapper {
    public abstract CheckoutDto checkoutToCheckoutDto(Checkout checkout);

    public abstract List<CheckoutDto> checkoutToCheckoutDto(Iterable<Checkout> checkout);

    public abstract Checkout checkoutDtoToCheckout(CheckoutDto checkoutDto);

    @Mapping(target="id", ignore = true)
    public abstract Checkout newCheckoutDtoToCheckout(CheckoutFormDataDto checkoutFormDataDto);

    @Mapping(target="id", ignore = true)
    public abstract void updateCheckoutFromFormCheckoutDto(@MappingTarget Checkout checkout, CheckoutFormDataDto checkoutFormDataDto);

}
