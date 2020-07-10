package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Error;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/Users")
public class UserController {

   public static class NotFoundException extends Exception{}
    public static class PayloadException extends Exception{}
    public static class NoSearchResultException extends Exception{}

    @Inject
    private UserRepo userRepo;

    //Shows all Users
    @Get(uri = "/", produces = {"application/json"})
    List<User> allUsers() throws NoSearchResultException {
        List<User> userList = (List<User>) userRepo.findAll();

        if (userList.isEmpty()){
            throw new NoSearchResultException();
        }

        return userList;
    }

    //Returns specific User
    @Get(uri = "/{id}", produces = {"application/json"})
    User findUser(@PathVariable("id") Long id) throws NotFoundException{
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException());
    }

    //Creating user
    @Post(value = "/create", consumes ={"application/json"},produces = {"application/json"})
    String createUser(@Body() User newUser) throws PayloadException {

        if (newUser == null || newUser.getName() == null){
            System.out.println("Test");
            throw new PayloadException();
        }

        userRepo.save(newUser);
        return "User created";
    }

    @Status(HttpStatus.NOT_FOUND)
    @Error(NotFoundException.class)
    public void handleNotFound(){}

    @Status(HttpStatus.BAD_REQUEST)
    @Error(PayloadException.class)
    public void handleBadPayload(){}

    @Status(HttpStatus.NO_CONTENT)
    @Error(NoSearchResultException.class)
    public void handleNoSearchResult(){}
}
