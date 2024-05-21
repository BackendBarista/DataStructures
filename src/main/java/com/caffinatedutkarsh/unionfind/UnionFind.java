package com.caffinatedutkarsh.unionfind;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnionFind<T> {

    private Map<T,Integer> bijection;
    private int[] parents;
    private T[] inverseBijection;

    private static <X> Map<X,Integer> createBijection(X[] elements ){
        return IntStream.range(0,elements.length)
                .boxed()
                .collect(Collectors.toMap((i)->elements[i], Function.identity()));

    }

    public UnionFind(T[] elements) throws IllegalArgumentException {
        if(elements.length == 0){
            throw new IllegalArgumentException("Empty list is not allowed.");
        }
        bijection = createBijection(elements);
        parents = IntStream.range(0,elements.length).toArray();
        inverseBijection = elements;
    }


    public T find(T element) throws IllegalArgumentException{
       if(bijection.containsKey(element)){
            int elementPosition = getElementPosition(element);
            return findParent(elementPosition);
        }else{
          throw new IllegalArgumentException("Element not found.");
        }
    }

    private T findParent(int currentPosition) {

        while (notSelfParent(currentPosition)){
            currentPosition = getParentPositionOf(currentPosition);
        }
        return getElementAt(currentPosition);
    }

    private boolean isSelfParent(int currentPosition){
        return currentPosition == getParentPositionOf(currentPosition);
    }

    private boolean notSelfParent(int currentPosition){
        return !isSelfParent(currentPosition);
    }

    private int getElementPosition(T element){
        return bijection.get(element);
    }

    private int getParentPositionOf(int elementPosition){
        return parents[elementPosition];
    }

    private T getElementAt(int position){
        if(position >= inverseBijection.length || position < 0){
            throw new IllegalArgumentException("Position provided is out of Array");
        }
        return inverseBijection[position];
    }
}
