package ge.vakhtang.pm.controller;

import ge.vakhtang.pm.model.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ge.vakhtang.pm.component.utils.Constants.HEARTBEAT_GREETING_MESSAGE;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/heartbeat")
    public ResponseEntity<GeneralResponse> heartbeat() {
        return ResponseEntity.ok(GeneralResponse.builder().message(HEARTBEAT_GREETING_MESSAGE).status(HttpStatus.OK.value()).build());
    }

}
