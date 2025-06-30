package conditional.model;

public record User(int age, Country country, String name) {

    public boolean canVote(Country currentCountry){
        return age > 18 && this.country.equals(currentCountry);
    }
}
