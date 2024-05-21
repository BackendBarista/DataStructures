package com.caffinatedutkarsh.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class UnionFindTest {

    private UnionFind<Character> uf;


    @BeforeEach
    public void createUnionFind(){
        uf = new UnionFind<>(new Character[]{'E','F','I','D','C','A','J','L','G','K','B','H'});
    }


    @Test
    public void findParentWithoutUnion(){
        assertThat(uf.find('E')).isEqualTo('E');
        assertThat(uf.find('F')).isEqualTo('F');
        assertThat(uf.find('I')).isEqualTo('I');
        assertThat(uf.find('H')).isEqualTo('H');
        assertThat(uf.find('A')).isEqualTo('A');
    }


}
