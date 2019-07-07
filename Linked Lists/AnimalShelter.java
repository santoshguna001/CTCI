
/** An animal shelter, which holds only dogs and cats, operates on a strictly"fist in, fist
out" basis. People must adopt either the"oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specifi animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linkedlist data structure. */
import java.util.LinkedList;
import java.util.Queue;

import com.sun.jmx.snmp.Timestamp;

class AnimalShelter {
    static class Animal {
        static LinkedList<Timestamp> dogs = new LinkedList<Timestamp>();
        static LinkedList<Timestamp> cats = new LinkedList<Timestamp>();

        public static void enqueue(Timestamp timestamp, char type) {
            if (type == 'd') {
                dogs.add(timestamp);
            } else {
                cats.add(timestamp);
            }
        }

        public static void dequeueAny() {
            if (cats.getFirst().toString().compareTo(dogs.getFirst().toString()) > 0) {
                System.out.println(dogs.removeFirst() + " - DOG");
            } else {
                System.out.println(cats.removeFirst() + " - CAT");
            }
        }

        public static void dequeueCat() {
            System.out.println(cats.removeFirst() + " - CAT");
        }

        public static void dequeueDog() {
            System.out.println(dogs.removeFirst() + " - DOG");
        }

    }

    public static void main(String[] args) throws InterruptedException {

    }
}