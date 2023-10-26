import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class UserDatabase {
    private Map<String, User> users;

    public UserDatabase() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

 class MiniSocialNetworking {
    public static void main(String[] args) {
        UserDatabase userDatabase = new UserDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    User newUser = new User(username, password);
                    userDatabase.addUser(newUser);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();
                    User loggedInUser = userDatabase.getUser(loginUsername);
                    if (loggedInUser != null && loggedInUser.getPassword().equals(loginPassword)) {
                        System.out.println("Logged in successfully!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}