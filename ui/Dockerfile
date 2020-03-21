FROM node:12.16-alpine as base_with_node_modules
WORKDIR /app
RUN apk update && apk add bash
COPY . /app
RUN npm ci

FROM base_with_node_modules as static_package
RUN npm run build