package AuthSystem_Project2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class User{
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

public class Authentication_System {
	
	private LinkedList<User>userList;
	public Authentication_System() {
		userList = new LinkedList<>();
	}
	
	public void register(String username, String password) {
		User newUser = new User(username, password);
		userList.add(newUser);
		System.out.println("User Registered Successfully");
	}
	
	public boolean login(String username, String password) {
		for(User user:userList) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Authentication_System authSys = new Authentication_System();
		Scanner scanner = new Scanner(System.in);
		boolean loggedIn = false;
		while(!loggedIn) {
			System.out.println("Choose an Option: ");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("Enter a username: ");
				String regUsername = scanner.nextLine();
				System.out.println("Enter a password:  ");
				String regPassword = scanner.nextLine();
				authSys.register(regUsername, regPassword);
				break;
			case 2:
				System.out.println("Enter your username: ");
				String loginUsername = scanner.nextLine();
				System.out.println("Enter a password: ");
				String loginPassword = scanner.nextLine();
				if(authSys.login(loginUsername, loginPassword)) {
					System.out.println("LoggedIn Successfully...");
					loggedIn = true;
				}
				else {
					System.out.println("Login Failed");
				}
				break;
			case 3:
				System.out.println("Exiting.....");
				loggedIn = true;
				break;
			default:
				System.out.println("Invalid choice, Please Try again.");
			
			}
		}
	}
}
