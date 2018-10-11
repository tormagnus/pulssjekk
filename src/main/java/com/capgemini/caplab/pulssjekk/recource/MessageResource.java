package com.capgemini.caplab.pulssjekk.recource;
import com.capgemini.caplab.pulssjekk.model.Message;
import com.capgemini.caplab.pulssjekk.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/messages")
public class MessageResource {


    @Autowired
    MessageRepository messageRepository;


    @GetMapping(value = "/all")
    public List<Message> getAll() {
        return messageRepository.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Message> getObjectActionStatus(@PathVariable ("id") Long id) {
        return new ResponseEntity<>(messageRepository.getOne(id), HttpStatus.NOT_IMPLEMENTED);
    }

/*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Message> getObject(@PathVariable ("id") Long id) {
        return new ResponseEntity<>(messageRepository.getReference(Message.class, id), HttpStatus.NOT_IMPLEMENTED);
    }

*/

/*
    @RequestMapping(value = "/objects/{oid}/actions/{aid}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<PropertyValue> executeObjectAction(@PathVariable UUID oid, @PathVariable String aid) {
        return new ResponseEntity<>(new PropertyValue(), HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Message get(@PathVariable("id") Long id) {
        return messageRepository.getOne(id);
    }




    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Message getMessage(@PathVariable ("id") Long id){
        return
    }
*/
    @PostMapping(value = "/")
    public Message persist(@RequestBody final Message message){
        return messageRepository.save(message);
    }
}
