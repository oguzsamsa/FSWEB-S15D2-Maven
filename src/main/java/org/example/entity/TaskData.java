package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String string){
        switch (string){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);

        }

        return null;
    }

    public Set<Task> getUnion(Set<Task>... sets){
        Set<Task> unionSet = new HashSet<>();
        for(Set<Task> set: sets){
            unionSet.addAll(set);
        }

        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> firstSet, Set<Task> secondSet){
        Set<Task> intersectedSet = new HashSet<>(firstSet);
        intersectedSet.retainAll(secondSet);
        return intersectedSet;
    }

    public Set<Task> getDifferences(Set<Task> firstSet, Set<Task> secondSet){
        Set<Task> firstSetCopy = new HashSet<>(firstSet);
        firstSetCopy.removeAll(secondSet);
        return firstSetCopy;
    }
}
