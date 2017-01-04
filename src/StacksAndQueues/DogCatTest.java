package StacksAndQueues;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Fuad Hasbun on 12/24/2016.
 */
public class DogCatTest {

    @Test
    public void enqueue() {
        DogCat myDogCat = new DogCat();
        AnimalNode cat1 = new AnimalNode(null, 0, "Cat");
        AnimalNode cat2 = new AnimalNode(null, 0, "Cat");
        AnimalNode cat3 = new AnimalNode(null, 0, "Cat");
        AnimalNode dog1 = new AnimalNode(null, 0, "Dog");
        myDogCat.enqueue(cat1);
        assertEquals(0, myDogCat.cats.front.counter);
        assertEquals(1, myDogCat.cats.size);
        assertEquals(0, myDogCat.dogs.size);
        myDogCat.enqueue(cat2);
        assertEquals(1, myDogCat.cats.front.next.counter);
        assertEquals(2, myDogCat.cats.size);
        assertEquals(0, myDogCat.dogs.size);
        myDogCat.enqueue(dog1);
        assertEquals(2, myDogCat.dogs.front.counter);
        assertEquals(2, myDogCat.cats.size);
        assertEquals(1, myDogCat.dogs.size);
        myDogCat.enqueue(cat3);
        assertEquals(3, myDogCat.cats.front.next.next.counter);
        assertEquals(3, myDogCat.cats.size);
        assertEquals(1, myDogCat.dogs.size);
    }

    @Test
    public void dequeue() {
        DogCat myDogCat = new DogCat();
        AnimalNode cat1 = new AnimalNode(null, 0, "Cat");
        AnimalNode cat2 = new AnimalNode(null, 0, "Cat");
        AnimalNode dog1 = new AnimalNode(null, 0, "Dog");
        AnimalNode dog2 = new AnimalNode(null, 0, "Dog");
        myDogCat.enqueue(cat2);
        myDogCat.enqueue(dog1);
        myDogCat.enqueue(cat1);
        myDogCat.enqueue(dog2);
        assertEquals(0, myDogCat.dequeue(null).counter);
        assertEquals(2, myDogCat.dequeue("Cat").counter);
        assertEquals(1, myDogCat.dequeue("Dog").counter);
    }
}
