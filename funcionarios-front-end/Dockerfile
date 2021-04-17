FROM node:lts-alpine
WORKDIR /app
COPY ./src .
COPY package*.json ./

RUN npm install -g @vue/cli
RUN npm install

EXPOSE 8080
CMD ["npm", "run", "build"]