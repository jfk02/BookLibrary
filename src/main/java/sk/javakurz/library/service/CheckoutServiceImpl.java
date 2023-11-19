package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.CheckoutDto;
import sk.javakurz.library.dto.CheckoutFormDataDto;
import sk.javakurz.library.exception.ResourceNotFoundException;
import sk.javakurz.library.mapper.CheckoutMapper;
import sk.javakurz.library.repository.CheckoutRepository;
import java.util.List;

@AllArgsConstructor
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutMapper checkoutMapper;

    @Override
    public CheckoutDto createCheckout(CheckoutFormDataDto checkoutFormDataDto) {
        var checkout = checkoutMapper.newCheckoutDtoToCheckout(checkoutFormDataDto);
        var savedCheckout = checkoutRepository.save(checkout);
        return checkoutMapper.checkoutToCheckoutDto(savedCheckout);
    }

    @Override
    public List<CheckoutDto> getAllCheckouts() {
        var allCheckouts = checkoutRepository.findAll();
        return checkoutMapper.checkoutToCheckoutDto(allCheckouts);
    }

    @Override
    public CheckoutDto findCheckoutById(Long checkoutId) {
        var checkout = checkoutRepository.findById(checkoutId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pôžička s ID: " + checkoutId + " neexistuje!"));
        return checkoutMapper.checkoutToCheckoutDto(checkout);
    }

    @Override
    public CheckoutDto updateCheckout(CheckoutFormDataDto updatedCheckout) {
        var checkout = checkoutRepository.findById(updatedCheckout.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pôžička s ID: " + updatedCheckout.getId() + " neexistuje!"));
        checkoutMapper.updateCheckoutFromFormCheckoutDto(checkout, updatedCheckout);
        var savedCheckout = checkoutRepository.save(checkout);
        return checkoutMapper.checkoutToCheckoutDto(savedCheckout);
    }

    @Override
    public void deleteCheckoutWithId(Long checkoutId) {
        checkoutRepository.deleteById(checkoutId);
    }
}
