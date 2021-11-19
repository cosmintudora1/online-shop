package ro.example.online.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OnlineShopException extends RuntimeException {

    private final String message;
}
