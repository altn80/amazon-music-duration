package com.novaes.amazon.music;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andre
 */
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    ArrayList<Integer> IDsOfSongs(int rideDuration,
            ArrayList<Integer> songDurations) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> songDurationsSorted = new TreeSet(songDurations.stream().sorted().collect(Collectors.toSet()));
        int i = 0;
        int j = songDurations.size() - 1;

        while (i != j) {
            int music1 = songDurationsSorted.first();
            int music2 = songDurationsSorted.last();
            if (music1 + music2 == rideDuration - 30) {
                break;
            }
            if (music1 + music2 < rideDuration - 30) {
                songDurationsSorted.pollFirst();
                i++;
            } else {
                songDurationsSorted.pollLast();
                j--;
            }
        }
        result.add(songDurations.indexOf(songDurationsSorted.first()));
        result.add(songDurations.indexOf(songDurationsSorted.last()));
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().IDsOfSongs(90, new ArrayList<>(Arrays.asList(new Integer[]{1, 40, 5, 10, 40, 20, 50, 5,150 , 55, 60, 58}))));
    }

}
// METHOD SIGNATURE ENDS
