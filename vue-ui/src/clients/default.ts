import axios from 'axios'

export const defaultClient = axios.create({
  baseURL: process.env.VUE_APP_API,
  headers: {
    'Content-Type': 'application/json',
  }
});