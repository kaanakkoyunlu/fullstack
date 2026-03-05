# ---------- build React app ----------
FROM node:20 AS build

WORKDIR /app

# install dependencies
COPY package*.json ./
RUN npm install

# copy source code
COPY . .

# build static files
RUN npm run build


# ---------- serve with nginx ----------
FROM nginx:alpine

# copy build output to nginx
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

