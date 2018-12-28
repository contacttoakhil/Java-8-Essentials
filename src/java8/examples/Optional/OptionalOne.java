package java8.examples.Optional;

import java.util.Optional;

public class OptionalOne {
    public static void main(String[] args) {
        String[] str = new String[10];
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){  // check for value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.print(lowercaseString);
        }else
            System.out.println("string value is not present");
    }
}

// What would happen if we replace Optional.ofNullable(str[5]) with Optional.of(str[5])
// Can we use lowercaseString = checkNull.get()?