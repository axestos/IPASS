package service;

public class ServiceProvider {
	private static UserService userService = new UserService();

	public static UserService getUserService() {
		return userService;
}}
