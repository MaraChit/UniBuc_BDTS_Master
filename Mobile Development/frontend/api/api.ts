import {User} from "../models/user";
import {Book} from "../models/book";

const baseUrl: string = "http://192.168.1.89:8001";
export const createUser = (user: User) => {
    return fetch(`${baseUrl}/users/signup/`, {method: 'POST', headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(user),})
}


export const loginUser = (user: User) => {
    return fetch(`${baseUrl}/users/login/`, {method: 'POST', headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(user),})
}

export const getBook = (username:string) => {
    return fetch(`${baseUrl}/books/getbook/`, {method: 'POST', headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({"username": username}),})
}

export const createBook = (book: Book, username: string) => {
    return fetch(`${baseUrl}/books/addbook/`, {method: 'POST', headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({...book, "username": username}),})
}