import Users.Create;

public class Main {
    public static void main(String[] args) {
        Create user = new Create(
                "Molxno",
                "3243638746",
                "molanosantiagoplay@gmail.com",
                "Alternova Inc",
                "Best backend developer"
        );

        user.createUser();
    }
}
