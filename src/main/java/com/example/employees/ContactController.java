package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContacts(@PathVariable int employeeID) {
        return contactService.getContact(employeeID);
    }

    @PostMapping(value="/create")
    public String addContacts(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    @PutMapping(value="/update/{id}")
    public String updateContact(@PathVariable int id, @RequestBody Contact contact){
        contact.setId(id);
        return contactService.updateContact(contact);
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteContact(@PathVariable int id){
        return contactService.deleteContact(id);
    }

}
