## Описание
- Репозиторий содержит простое CRUD-приложение с сущностями User и Order.
- Реализованы методы для создания, чтения, удаления и обновления сущностей.
- В качестве базы данных используется PostgreSQL, настройки для поддключения к базе находятся в файле resources/application.properties
- Реализовано логирование происходящих событий с помощью Spring AOP
- Запись логов ведется как в консоль, так и в файл src/log/app.log
- Конфигурация находится в файле resources/log4j2.xml. При запуске в не-UNIX среде необходимо указать путь для создания log-файла в разделе Properties APP_LOG_ROOT.

## Особенности реализации
- Была исключена стандартная зависимость для логирования:
 
`<groupId>org.springframework.boot</groupId>`  
`<artifactId>spring-boot-starter-logging</artifactId>`

- Была добавлена новая зависимость:  
`<groupId>org.springframework.boot</groupId>`  
`<artifactId>spring-boot-starter-log4j2</artifactId> `

Был создан отдельный класс аспекта, помеченный аннотацией @Aspect.  
В качестве Pointcut были выбраны все методы в пакете service.  
Аспект фиксирует в логе начало выполнения каждого метода выражением, начинающимся с "Enter", а также отображает переданные аргументы.  
По завершении метода аспект создает запись, начинающуюся с "Exit", а также приводит результат выполнения в виде String.  
В случае выброса исключений аспект также фиксирует их в логах.  

## Примеры логов
Начало работы метода:  
`DEBUG Enter: com.example.autheticationhw.service.OrderService.get() with argument[s] = [1]`  
Окончание работы метода:  
`DEBUG Exit com.example.autheticationhw.service.OrderService.get() with result = Order{id=1, status=ACCEPTED, user=user1}`
Выброс исключения:  
`ERROR Exception in com.example.autheticationhw.service.OrderService.get() with cause = NULL  `

## Тестирование
В классах OrderServiceTest и UserServiceTest реализован запуск всех методов в нормальных условиях, а также запуск метода `get(long id)` для несуществующей сущности для проверки логирования исключений.

## Запуск
mvn spring-boot:run
