import java.util.Objects;

public class Person {
    String name;
    int num;

    Person(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

//    public void getMessages(){
//        int messagesCount=0;
//        Message[] msg=new Message[100];
//        {
//            msg[messagesCount++]=new Message(name,"To me","How Are you?");
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(num,person.num) ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }


}