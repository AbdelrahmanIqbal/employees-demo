package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final EmployeeRepository employeeRepository;

    public ContactService(ContactRepository contactRepository, EmployeeRepository employeeRepository) {
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
    }

    List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    Contact getContact(int employeeID){
        return contactRepository.findById(employeeID).orElseThrow();
    }

    String createContact(Contact contact){
        try {
            contactRepository.save(contact);
            return "Contact details have been created for employee number #" + contact.getId();
        } catch(Exception e){
            return e.getMessage().toString();
        }
    }

    String updateContact(Contact contact){
        if (contactRepository.existsById(contact.getId())) {
            try {
                contactRepository.save(contact);
                return "Employee #" + contact.getId() + " has been updated";
            } catch(Exception e){
                return e.getMessage().toString();
            }
        } else{
            return "Contacts don't exist.";
        }
    }

    String deleteContact(int id){
        if (contactRepository.existsById(id)) {
            Contact contact =  contactRepository.findById(id).orElseThrow();
            try {
                contactRepository.delete(contact);
                return "Contacts #" + id + " has been deleted.";
            } catch(Exception e){
                return e.getMessage().toString();
            }
        } else {
            return "Contacts #" + id + " do not exist.";
        }
    }


}
