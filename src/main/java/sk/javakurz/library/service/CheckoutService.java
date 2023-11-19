package sk.javakurz.library.service;

import sk.javakurz.library.dto.CheckoutDto;
import sk.javakurz.library.dto.CheckoutFormDataDto;
import java.util.List;

public interface CheckoutService {
    CheckoutDto createCheckout(CheckoutFormDataDto checkoutFormDataDto);

    List<CheckoutDto> getAllCheckouts();

    CheckoutDto findCheckoutById(Long checkoutId);

    CheckoutDto updateCheckout(CheckoutFormDataDto updatedCheckout);

    void deleteCheckoutWithId(Long checkoutId);
}
