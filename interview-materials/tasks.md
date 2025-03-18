# Tasks

## Pet Clinic REST API

Design REST service related with Pet Clinic, where pets have name and age.
Add operation with pets batch update (for example, add new field - owner).

- GET `/api/v1/clinic/{id}`
- DELETE `/api/v1/clinic/{id}`
- POST `/api/v1/clinic`  
  params: { name: ..., age : ... }
- PUT `/api/v1/clinic/{id}`  
  params: { age: ... }
- PATCH `/api/v1/clinic`  
  params: { ids: ..., owner: ... }

## Sorting big strings task

Propose algorithm for sorting a bunch of long strings situated on disk.
We have restriction of RAM size: so only one string could be loaded into RAM simultaneously.

## Сортировки:

- быстрая
    - со стеками
    - на месте
- блочная

## Хеш-таблицы:

- пробирование
    - линейное
    - квадратичное
    - псевдослучайное
- хеширование
    - одинарное
    - двойное

## Сочетания, размещения

- с повторениями
- без повторений

## Деревья:

- добавление вершин
- поиск вершин
- удаление вершин
- префиксные деревья

## Search engine with suggestion ability

We have search engine, it provides web-interface with text field where a query could be typed.
We want to add the next feature: when a user starts typing - he will get a suggestion
with 10 most popular queries started from typed characters.
File with the most popular searches generated 1 time per day, it contains 1 mln lines, sorted by popularity.
Propose the design of such system.

## Multithreading

Реализовать ReadWriteLock на базе обычного Lock
