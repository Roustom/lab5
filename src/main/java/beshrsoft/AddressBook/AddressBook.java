package beshrsoft.AddressBook;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyList;
    @Id
    @GeneratedValue
    private long id;

    public AddressBook(){
        buddyList= new LinkedList<BuddyInfo>();
    }

    public long getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public void addBuddy(BuddyInfo b){
        buddyList.add(b);

    }

    public String returnText(){
        String s = "";
        if(buddyList.isEmpty()){
            s=s+"List is empty";
        }else {
            for (BuddyInfo b : buddyList) {
                s = s + b.getName() + "    " + b.getEmail() + "\n";
            }
        }
        return s;
    }

    public BuddyInfo removeBuddy(){
        if(buddyList.isEmpty()){

        }else{
            return buddyList.remove(0);

        }
        return null;
    }

    public List<BuddyInfo> getBuddyList(){
        return buddyList;
    }

    public void setBuddyList(LinkedList<BuddyInfo> bL){
        this.buddyList=bL;
    }
    public void printList(){
        System.out.println("Buddies in the list:");
        for (BuddyInfo b : buddyList){
            System.out.println(b.getName());
        }
    }

    public static void main(String[] args) {
        AddressBook list = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("Beshr", "b@gmail.com",21);
        BuddyInfo b2 = new BuddyInfo("Saad", "s@gmail.com",22);
        BuddyInfo b3 = new BuddyInfo("test", "d@gmail.com",23);
        BuddyInfo b4 = new BuddyInfo("whatever", "f@gmail.com",24);
        list.addBuddy(b1);
        list.addBuddy(b2);
        list.addBuddy(b3);
        list.addBuddy(b4);
        list.printList();
    }
}
