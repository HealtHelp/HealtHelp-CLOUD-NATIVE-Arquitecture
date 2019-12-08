export const BASIC_AUTH  = {   
    username: 'healthelp',
    password: '4YMze5ZOOXZzTRFC66Ai'
}

export const HEADERS = {
    'Content-Type': 'application/x-www-form-urlencoded',
    "Access-Control-Allow-Origin":"http://localhost:3001",
    'Authorization': 'Basic ' +  btoa(BASIC_AUTH.username + ":" + BASIC_AUTH.password)
  }
export const URL_LOGIN = 'http://localhost:3001/hho/oauth/token';