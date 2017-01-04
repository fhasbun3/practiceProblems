package StacksAndQueues;

/**
 * Created by Fuad Hasbun on 12/22/2016.
 */
public class DogCat {
    AnimalQueue dogs, cats;

    public void enqueue(AnimalNode animal){
        if (dogs == null && cats == null) {
            dogs = new AnimalQueue();
            cats = new AnimalQueue();
        }
        if (animal == null) {
            //Do nothing
        } else {
            animal.counter = cats.size + dogs.size;
            if (animal.data.equals("Cat")) {
                cats.enqueue(animal);
            } else {
                dogs.enqueue(animal);
            }
        }
    }

    public AnimalNode dequeue(String str) {
        if (str == null) {
            if (dogs.front.counter < cats.front.counter) {
                return dogs.dequeue();
            } else {
                return cats.dequeue();
            }
        } else if (str.equals("Dog")) {
            return dogs.dequeue();
        } else {
            return cats.dequeue();
        }
    }
}
