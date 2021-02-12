package beshrsoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyInfoController {
    private BuddyInfoRepository buddyInfoRepo;
    private AddressBookRepository addressBookRepo;

    @Autowired
    public BuddyInfoController( BuddyInfoRepository buddyRepo, AddressBookRepository bookRepo){
        this.buddyInfoRepo = buddyRepo;
        this.addressBookRepo = bookRepo;
    }
    @RequestMapping(value = "/addressbook/buddyinfo", method = RequestMethod.POST)
    public BuddyInfo addBuddyInfo(@RequestParam("addressBookId") Long addressBookId, @RequestBody BuddyInfo buddyInfo){
        AddressBook addressBook = addressBookRepo.findById(addressBookId).get();
        addressBook.addBuddy(buddyInfo);
        buddyInfoRepo.save(buddyInfo);
        addressBookRepo.save(addressBook);
        return buddyInfo;
    }
    @RequestMapping(value="/addressbook/buddyinfo", method = RequestMethod.GET)
    public BuddyInfo getBuddyInfo(@RequestParam("addressBookId") Long addressBookid, @RequestParam("buddyInfoId") Long buddyInfoId){
        AddressBook addressBook = this.addressBookRepo.findById(addressBookid).get();
        return this.buddyInfoRepo.findById(buddyInfoId).get();
    }
    @RequestMapping(value = "/addressbook/buddyinfo", method = RequestMethod.DELETE)
    public String removeBuddyInfo(@RequestParam("addressBookId") Long addressBookId){
        AddressBook addressBook = addressBookRepo.findById(addressBookId).get();
        BuddyInfo buddy =addressBook.removeBuddy();
        buddyInfoRepo.delete(buddy);
        addressBookRepo.save(addressBook);
        return "request is successful";
    }
}
