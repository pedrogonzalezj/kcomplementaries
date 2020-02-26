package com.devo.kcomplentary;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParserImpl implements InputParser {

    private Pattern inputFormat;

    public InputParserImpl() {
        inputFormat = Pattern.compile("(\\d+)[\\s\\n]*");
    }

    @Override
    public Integer[] parse(String in) {
        final Matcher inputMatcher = inputFormat.matcher(in);
        final List<Integer> numbers = new ArrayList<>();
        while(inputMatcher.find()) {
            numbers.add(Integer.parseInt(inputMatcher.group().trim()));
        }
        return numbers.toArray(new Integer[0]);
    }
}
