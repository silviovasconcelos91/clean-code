package conditional;


import conditional.model.Country;
import conditional.model.Item;
import conditional.model.User;

public class ConditionalExamples {

    // Negative conditionals
    public void someMethod(Item[] items) {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                System.out.println("I'm aged brie");
            } else {
                System.out.println("I'm not aged brie");
            }
        }
    }

    // encapsulate conditionals
    public void someOtherMethod(User user, Country currentCountry) {
        if (user.canVote(currentCountry)) {
            System.out.println(user.name() + " can vote");
        } else {
            System.out.println(user.name() + " cannot vote");
        }
    }

    private static boolean isAgedBrie(Item items) {
        return items.name().equals("Aged Brie");
    }
}