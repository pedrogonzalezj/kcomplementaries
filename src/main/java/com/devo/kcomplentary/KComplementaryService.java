package com.devo.kcomplentary;

import java.util.Set;

public interface KComplementaryService {

    Set<Pair> getKComplementaries(final Integer[] numbers, final int kNumber);
}
