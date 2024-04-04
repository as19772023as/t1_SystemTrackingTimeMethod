## Задание: Реализация системы учета времени выполнения методов

#### Описание:
Вам предстоит разработать систему учета времени выполнения методов в приложении с использованием Spring AOP. Система должна быть способна асинхронно логировать и анализировать данные о времени выполнения методов.

#### Требования:
Создайте аннотации @TrackTime и @TrackAsyncTime, которые можно применять к методам для отслеживания времени их выполнения.
Реализуйте аспекты, используя Spring AOP, для асинхронного и синхронного отслеживания времени выполнения методов, помеченных соответствующими аннотациями.
Создайте сервис, который будет асинхронно сохранять данные о времени выполнения методов в базе данных.
Реализуйте REST API для получения статистики по времени выполнения методов (например, среднее время выполнения, общее время выполнения) для различных методов и их групп.
Настройте приложение с помощью конфигурации Spring для включения использования AOP и асинхронной обработки данных.

#### Критерии оценки:
Реализация аспектов:
Правильное применение Spring AOP для создания аспектов.
Корректное определение точек среза для методов, помеченных аннотациями @TrackTime и @TrackAsyncTime.
Обработка исключений и ошибок в аспектах.

#### Обработка асинхронных вызовов:
Асинхронное отслеживание времени выполнения методов, помеченных аннотацией @TrackAsyncTime.
Корректная обработка результатов асинхронных операций.

#### Хранение и анализ данных:
Реализация сервиса для асинхронного сохранения данных о времени выполнения методов в базе данных.
Корректное хранение данных в базе данных.
Реализация механизма анализа данных для получения статистики по времени выполнения методов.

#### REST API:
Создание REST API для получения статистики по времени выполнения методов.
Корректная обработка запросов и передача данных в формате JSON.
Документация API.

#### Качество кода и архитектура:
Чистота, читаемость и модульность кода.
Соблюдение принципов SOLID и других принципов проектирования.
Правильное использование паттернов проектирования.

## Реализация
- Приложение разработано с использованием Spring AOP 
- Java 17
- Использован сборщик пакетов maven
- Используется БД PostgreSQL 
- Код размещен на github

### Описание

Проект состоит:

-  из 2-х тестовых  приложений,
     1. Тестовое Приложение №1 (получение статистики из БД c таблицей - Person, во время запуск приложения тестовые данные мигрируются автоматически),
     2. Тестовое Приложение №2 (имитация работы метода, по установленному интервалу - Sleep)
- Системы учета времени выполнения методов с использованием аннотаций,
     - @TrackTime - для  синхронного отслеживания времени выполнения методов,
     - @TrackAsyncTime - для асинхронного  отслеживания времени выполнения методов.
- Сервиса для асинхронного сохранения данных о времени выполнения методов в базе данных -Statistics.

#### Эндпоинты для Приложений №1-2:
- Для приложения №1    /persons/by-city  (localhost:8080/persons/by-city?city=Moscow)
- Для приложения №2    /sleep            (localhost:8080/sleep?sleep=2000)

#### Запуск проекта 

1. Создать в БД schema = "t1persons" (перед первым запуском)
2. Запустить проект
3. Данные о времени выполнения методов сохраняются в БД.
4. Воспользоваться системой учета времени выполнения методов
5. Проверка будет доступен из браузера по ссылке http://localhost:8080/.....................

### Обработка запросов системы учета времени выполнения методов

#### Эндпоинты 
- /statistics/totalTime? _____________(localhost:8080/statistics/totalTime?method=getSleep) 
   для получения статистики общего времени выполнения выбранного метода 

- /statistics/avgTime ________________(localhost:8080/statistics/avgTime?method=getPersonsByCity)
   для получения статистики среднего времени выполнения выбранного метода

- /statistics/totalTime/group ________(localhost:8080/statistics/totalTime/group?method1=getSleep&method2=getPersonsByCity)
  
- /statistics/avgTime/group __________(localhost:8080/statistics/avgTime/group?method1=getSleep&method2=getPersonsByCity)

## При успешном завершении, отображается результат статистики.