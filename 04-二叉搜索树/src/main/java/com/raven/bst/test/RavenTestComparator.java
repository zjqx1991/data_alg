package com.raven.bst.test;

import com.raven.bst.IRavenNodeComparator;

public class RavenTestComparator implements IRavenNodeComparator<Person> {
    @Override
    public int comparaTo(Person e1, Person e2) {
        return e1.getAge() - e2.getAge();
    }
}
