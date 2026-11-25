import java.util.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String username = null;
        String name = "Raghu";

        Optional<String> user = Optional.ofNullable(username);

        System.out.println(user.isPresent());

        System.out.println(user.isEmpty());

        user.ifPresent(name1 -> System.out.println("welcome " + name1));

        System.out.println(
            user.orElseGet(() -> " default value")
        );

        Optional<String> user1 = Optional.of(name);

        System.out.println(user1.get());

        user1 = Optional.ofNullable(username);

        user1 = Optional.empty();

        System.out.println(user1.orElse("there is no data"));
    }
}

