package com.devo.kcomplentary;

import java.util.*;

public class KComplementaryServiceImpl implements KComplementaryService {

    public Set<Pair> getKComplementaries(final Integer[] numbers, final int kNumber) {
        final Set<Pair> pairs = new HashSet<>();
        final Map<Integer,Integer> indexesMap = new HashMap<>();
        for(int i = 0; i<numbers.length; i++) {
            indexesMap.put(numbers[i],i);
        }
        for(int i = 0; i<numbers.length; i++) {
            final int complementary = kNumber - numbers[i];
            if(indexesMap.containsKey(complementary)) {
                pairs.add(new Pair(i,indexesMap.get(complementary)));
            }
         }
        return pairs;
    }
}
