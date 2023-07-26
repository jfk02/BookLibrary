package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import sk.javakurz.library.dto.CheckoutDto;
import sk.javakurz.library.entity.Checkout;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {
    CheckoutDto checkoutToCheckoutDto(Checkout checkout);

    List<CheckoutDto> checkoutToCheckoutDto(Iterable<Checkout> checkout);

    Checkout checkoutDtoToCheckout(CheckoutDto checkoutDto);

    List<Checkout> checkoutDtoToCheckout(Iterable<CheckoutDto> checkoutDto);
}
