package beshrsoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    private AddressBookRepository addressBookRepo;

    @Autowired
    public AddressBookController( AddressBookRepository repo){
        this.addressBookRepo = repo;
    }
@RequestMapping(value = "/addressbook", method = RequestMethod.POST)
    public AddressBook addAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepo.save(addressBook);
        return addressBook;
    }
@RequestMapping(value="/addressbook", method = RequestMethod.GET)
    public AddressBook getAddressBook(@RequestParam("id") Long id){
        return this.addressBookRepo.findById(id).get();
    }
}
