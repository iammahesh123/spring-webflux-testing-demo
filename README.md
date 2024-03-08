# Spring WebFlux Testing Demo

This project demonstrates how to test Spring WebFlux controllers and services using JUnit 5 and Mockito. It includes the following components:

- **UserController**: REST controller responsible for handling user-related HTTP requests.
- **UserService**: Service interface defining operations related to user management.
- **UserServiceImpl**: Implementation of the UserService interface.
- **UserRepository**: Reactive CRUD repository for managing user data.
- **UserControllerTest**: JUnit 5 test class for testing UserController methods.
- **UserServiceTest**: JUnit 5 test class for testing UserService methods.

## Setup

To run this project locally, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/spring-webflux-testing-demo.git
    ```

2. Import the project into your preferred IDE.

3. Run the JUnit tests located in the `src/test/java` directory.

## Technologies Used

- Java
- Spring WebFlux
- JUnit 5
- Mockito
- Reactor

## Usage

1. Run the provided JUnit tests to ensure that the UserController and UserService are functioning as expected.

2. Modify or extend the UserController and UserService as needed for your application requirements.

## Contributions

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
