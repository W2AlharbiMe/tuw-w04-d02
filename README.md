# users systen



### Endpoints:
---

1. get all users
```js
// GET /api/v1/users/get

// RESPONSE:
[
    {
        "id": 1,
        "name": "user3",
        "username": "user3",
        "password": "12345678",
        "email": "user3@saudi.sa",
        "role": "user",
        "age": 26
    },
    {
        "id": 2,
        "name": "admin",
        "username": "admin2",
        "password": "12345678",
        "email": "admin2@saudi.sa",
        "role": "admin",
        "age": 26
    }
]
```

2. create new user
```js
// POST /api/v1/users/create

// JSON Body:
{
    "name": "admin",
    "username": "admin2",
    "email": "admin2@saudi.sa",
    "password": "12345678",
    "age": 26,
    "role": "admin"
}

// RESPONSE:
{
    "message": "the user have been created.",
    "data": {
        "id": 1,
        "name": "admin",
        "username": "admin2",
        "password": "12345678",
        "email": "admin2@saudi.sa",
        "role": "admin",
        "age": 26
    }
}```

3. update user
```js
// PUT /api/v1/users/update/{id}

// JSON Body:
{
    "name": "user4",
    "username": "user4",
    "email": "user4@saudi.sa",
    "password": "12345678",
    "age": 26,
    "role": "user"
}

// RESPONSE WHEN INCREASE:
{
    "message": "the user have been updated.",
    "data": {
        "id": 2,
        "name": "user4",
        "username": "user4",
        "password": "12345678",
        "email": "user4@saudi.sa",
        "role": "user",
        "age": 26
    }
}
```

4. delete user
```js
// DELETE /api/v1/users/{id}/delete

// RESPONSE:
{
    "message": "the user have been deleted.",
    "data": {
        "id": 1,
        "name": "admin",
        "username": "admin2",
        "password": "12345678",
        "email": "admin2@saudi.sa",
        "role": "admin",
        "age": 26
    }
}
```


