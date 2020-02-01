export const BASIC_AUTH  = {   
    username: 'healthelp',
    password: '4YMze5ZOOXZzTRFC66Ai'
}

export const HEADERS = {
    'Content-Type': 'application/x-www-form-urlencoded',
    "Access-Control-Allow-Origin":"http://localhost:3000",
    'Authorization': 'Basic ' +  btoa(BASIC_AUTH.username + ":" + BASIC_AUTH.password)
  }
export const URL_LOGIN = 'http://localhost:3000/hho/oauth/token';
//Users
export const URL_GET_USERS = 'http://localhost:3000/hhu/api/v1/users?page=0&size=10&sort=username'
export const URL_SET_USER = 'http://localhost:3000/hhu/api/v1/users'