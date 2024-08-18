# Prerequisites

- PHP 8.2
- JDK 21
- MySQL (e.g., via XAMPP)

# How to Run the Code

## 1. Clone the Repositories
Clone both the Spring Boot and CodeIgniter 3 projects:
```bash
git clone https://github.com/percivalyan/msib-test-ci3.git
```

```bash
git clone https://github.com/percivalyan/msib-test-springboot.git
```

## 2. Create and Configure the Database
Spring Boot (resources/application.properties)
Create a MySQL database named msib_company. Then, configure the database settings in the application.properties file:
```bash
spring.application.name=be-company
spring.datasource.url=jdbc:mysql://localhost:3306/msib_company
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

CodeIgniter 3 (config/database.php)
In the database.php file, configure the database settings as follows:
```bash
$db['default'] = array(
    'dsn'	   => '',
    'hostname' => '127.0.0.1',
    'port'	   => 3307,
    'username' => 'root',
    'password' => 'root',
    'database' => 'msib_company',
    'dbdriver' => 'mysqli',
    'dbprefix' => '',
    'pconnect' => FALSE,
    'db_debug' => (ENVIRONMENT !== 'production'),
    'cache_on' => FALSE,
    'cachedir' => '',
    'char_set' => 'utf8',
    'dbcollat' => 'utf8_general_ci',
    'swap_pre' => '',
    'encrypt' => FALSE,
    'compress' => FALSE,
    'failover' => array(),
    'save_queries' => TRUE
);
```

## 3. Run the Spring Boot Project
Open the Spring Boot project in your IDE (e.g., Visual Studio Code) and run the application:
1. Ensure you have the Java and Spring Boot extensions installed.
2. Run the project using the ```Run Java```

## 4. Install Dependencies for CodeIgniter 3
Navigate to the CodeIgniter 3 project directory and install the necessary dependencies:
```bash
composer install
```

## 5. Run the CodeIgniter 3 Project
Start the CodeIgniter 3 project using the built-in PHP server:
```bash
php -S localhost:8000
```

## 6. Access the Application
Open your browser and navigate to:
```bash
http://localhost:8000
```
You should see the message:
```PHP 8.2.12 Development Server (http://localhost:8000) started```
