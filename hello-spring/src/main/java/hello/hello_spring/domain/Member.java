package hello.hello_spring.domain;

import javax.persistence.*;


@Entity
public class Member {  //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "username")
    private String name;

    /*public Long getID(){ //내가 직접 입력하는것

        return id;
    }*/

    public Long getId() { //스프링 내부에 선언된 수 1 2 3 4 ...
        return id;
    }

    public void setId(Long id){

        this.id = id;
    }
    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }
    public String toString() {
        return "Member{id=" + id + ", name='" + name + "'}";
    }
}
