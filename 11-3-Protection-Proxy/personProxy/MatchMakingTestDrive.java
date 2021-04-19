package personProxy;

import java.lang.reflect.*;
import java.util.HashMap;

public class MatchMakingTestDrive {
    private HashMap<String, Person> database = new HashMap<String, Person>();
    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    public void drive() {
        Person joe = getPersonFromDatabase("Joe Javabean");
        System.out.println("A OwnerProxy created");
        Person ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        System.out.println("Interest is " + ownerProxy.getInterests());
        ownerProxy.setInterests("bowling, go");
        System.out.println("Interrests set from owner proxy");
        System.out.println("Interest is " + ownerProxy.getInterests());
        System.out.println("Rating is " + ownerProxy.getGeekRating());
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        Person nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("A NonOwnerProxy created");
        System.out.println("Name is " + nonOwnerProxy.getName());
        System.out.println("Interest is " + ownerProxy.getInterests());
        try {
            nonOwnerProxy.setInterests("bowling, go");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + ownerProxy.getGeekRating());
    }

    //    //https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Proxy.html#newProxyInstance(java.lang.ClassLoader,java.lang.Class%5B%5D,java.lang.reflect.InvocationHandler)
    private Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
                );
    }

    private Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person)
                );
    }

    private Person getPersonFromDatabase(String name) {
        return (Person) database.get(name);
    }

    private void initializeDatabase() {
        Person joe = new PersonImpl();
        joe.setName("Joe Javabean");
        joe.setInterests("cars, computers, music");
        joe.setGeekRating(7);
        database.put(joe.getName(), joe);

        Person kelly = new PersonImpl();
        kelly.setName("Kelly Klosure");
        kelly.setInterests("ebay, movies, music");
        kelly.setGeekRating(6);
        database.put(kelly.getName(), kelly);
    }
}
