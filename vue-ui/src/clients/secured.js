import axios from 'axios';
import Cookie from 'js-cookie';
import api from "./default";
import store from '../store';

const secured = axios.create({
  baseURL: process.env.VUE_APP_API,
  headers: {
    'Content-Type': 'application/json',
  }
});

secured.interceptors.request.use((config) => {
  const accessToken = localStorage.getItem('accessToken');
  if (accessToken !== null) {
    // console.log('[interceptor req] add bearer token');
    config.headers.Authorization = `Bearer ${accessToken}`;
  }
  return config;
}, (error) => {
  return Promise.reject(error);
});

secured.interceptors.response.use(
  (response) => {
    // console.log('[interceptor] received secured response');
    return response;
  },
  (error) => {
    const originalRequest = error.config;
    // console.log(`[interceptor resp] error response in secured call [ Status: ${error.response.status} , Retry: ${originalRequest._retry} ]`);

    const isUnauthorized = error.response.status === 401;

    if ((isUnauthorized) && originalRequest._retry !== true) {

      // console.log('[interceptor resp] refreshing access token, then retrying secured request');
      originalRequest._retry = true;

      return refreshToken()
        .then(() => {
          // console.log('[interceptor resp] refreshed access_token');
          return secured.request(originalRequest);
        })
        .catch((error) => {
          // console.log(error);
          return Promise.reject(error);
        });
    }
    return Promise.reject(error);
  });


function refreshToken() {
  return new Promise((resolve, reject) => {
    if (!getRefreshToken()) {
      reject('[refresh token] no refresh token found');
    }

    let options = {
      method: 'post',
      url: '/authentication/token/refresh',
      data: {
        accessToken: getAccessToken(),
        refreshToken: getRefreshToken(),
      },
    };
    api(options).then(function (response) {
      saveTokens(response.data);
      store.commit('setUser');
      resolve(response)
    }).catch(function (error) {
      store.commit('deleteUser', true);
      reject(error)
    })
  })
}

/**
 * @returns {string | null}
 */
function getAccessToken() {
  return localStorage.getItem('accessToken');
}

/**
 * @returns {string | null}
 */
function getRefreshToken() {
  return localStorage.getItem('refreshToken');
}

export function saveTokens({ accessToken, refreshToken, nodebbToken, gitlabToken }) {
  if (accessToken) {
    localStorage.setItem('accessToken', accessToken);
  }
  if (refreshToken) {
    localStorage.setItem('refreshToken', refreshToken);
  }
  if (gitlabToken) {
    localStorage.setItem('gitlabToken', gitlabToken);
  }
  if (nodebbToken) {
    Cookie.set(
      process.env.VUE_APP_NODEBB_COOKIE_NAME,
      nodebbToken,
      {
        expires: 30,
        domain: process.env.VUE_APP_NODEBB_COOKIE_DOMAIN,
        secure: process.env.VUE_APP_NODEBB_COOKIE_SECURE
      }
    );
  }
  return true;
}

export default secured;