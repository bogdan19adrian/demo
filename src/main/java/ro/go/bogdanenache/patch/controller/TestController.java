package ro.go.bogdanenache.patch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.go.bogdanenache.patch.api.UserDTO;
import ro.go.bogdanenache.patch.api.update.PatchUserDTO;
import ro.go.bogdanenache.patch.service.TestService;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private final  TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser() {
        log.info("GET user");
        return new ResponseEntity<UserDTO>(testService.getUser(), HttpStatus.OK);
    }

    @PatchMapping(value = "partial")
    public ResponseEntity<PatchUserDTO> partialUpdateUser(@RequestBody PatchUserDTO user) throws IllegalAccessException, InstantiationException {
        log.info("PATCH user");
        log.info("REQUEST user {}", user);
        return  new ResponseEntity(testService.updateUserPartial(user), HttpStatus.OK);
    }

    @PatchMapping(value = "full")
    public ResponseEntity<PatchUserDTO> fullUpdateUser(@RequestBody UserDTO request)  {
        log.info("PATCH user");
        log.info("REQUEST user {}", request);

        return new ResponseEntity(testService.updateUserFull(request), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        log.info("POST user");
        log.info("REQUEST user {}", user);
        return null;
    }



}
