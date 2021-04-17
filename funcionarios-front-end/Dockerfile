FROM node:lts-alpine
WORKDIR /app
#COPY package*.json ./
#COPY ./package*.json ./
COPY . /app

RUN npm install -g @vue/cli
RUN npm install

EXPOSE 8080
CMD ["npm", "run", "serve"]