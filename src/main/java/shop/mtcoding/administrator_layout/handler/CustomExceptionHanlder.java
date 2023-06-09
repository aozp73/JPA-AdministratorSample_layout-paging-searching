package shop.mtcoding.administrator_layout.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.administrator_layout.handler.ex.CustomException;
import shop.mtcoding.administrator_layout.util.Script;

// Exception 전용 Controller

// @ControllerAdvice // 파일리턴하는 Handler로 사용

@RestControllerAdvice // Data 리턴하는 Handler로 사용
public class CustomExceptionHanlder {

    // NullPointException도 RuntimeException의 자식

    @ExceptionHandler(CustomException.class) // 이러면 CustomException 터지면 아래 메서드가 다 낚아챔
    public ResponseEntity<?> customException(CustomException e) {
        return new ResponseEntity<>(Script.back(e.getMessage()), e.getStatus());
        // return Script.back(e.getMessage()); // CustomException이 터지면 이 messsage 응답할 거임
    }
}
