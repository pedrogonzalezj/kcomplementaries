package com.devo.kcomplentary;



import org.apache.commons.cli.*;


import java.util.Scanner;
import java.util.Set;


public class App {

    private static final String INIT_MESSAGE = "Please enter input as a collection of integer values separated by white spaces (12 123 1 43)...";

    public static void main( String[] args ) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Exited from KComplementary checker program")));
        int kNumber = 0;
        final Options options = new Options();
        final Option option = Option.builder("k")
                .argName("k")
                .longOpt("knumber")
                .hasArg(true)
                .numberOfArgs(1)
                .required(true)
                .type(Integer.class)
                .desc("K number for checking K Complementaries")
                .build();
        options.addOption(option);
        try {
            final CommandLineParser cmd = new DefaultParser();
            final CommandLine line = cmd.parse(options, args);
            kNumber = Integer.parseInt(line.getOptionValue("knumber"));
        } catch (ParseException pex) {
            System.out.println(pex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "k complementaries", options);
            System.exit(1);
        }
        final InputParser inputParser = new InputParserImpl();
        final KComplementaryService service = new KComplementaryServiceImpl();
        final Scanner scanner = new Scanner(System.in);
        System.out.println(INIT_MESSAGE);
        while(true) {
            System.out.print("K Complementaries> ");
            final String numbers = scanner.nextLine();
            final Integer[] maybeNumbers = inputParser.parse(numbers);
            if(maybeNumbers.length == 0) {
                System.out.println(INIT_MESSAGE);
                continue;
            }
            final Set<Pair> pairs = service.getKComplementaries(maybeNumbers,kNumber);
            System.out.println("Found:");
            pairs.forEach(p -> System.out.println(p.toString()));
            System.out.println("pairs");
        }
    }
}
