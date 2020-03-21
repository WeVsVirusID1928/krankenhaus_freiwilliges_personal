FROM node:12.16-alpine
RUN apk update && apk add bash
WORKDIR /app
COPY . /app
RUN npm install
EXPOSE 1357

ENTRYPOINT [ "npm", "start" ]