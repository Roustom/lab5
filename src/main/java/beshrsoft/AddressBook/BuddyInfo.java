package beshrsoft.AddressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;
    private String email;
    private int age;
    private long id;

    public BuddyInfo(){
        this.name=name;
        this.email=email;
        this.age=age;
    }
    public BuddyInfo(String name, String email, int age){
            this.name=name;
            this.email=email;
            this.age=age;
    }
    @Id
    @GeneratedValue
    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
