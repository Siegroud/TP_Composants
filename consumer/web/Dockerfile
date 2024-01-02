# Use an official Node runtime as a base image
FROM node:14

# Set the working directory to /app
WORKDIR /app

# Copy package.json and package-lock.json to /app
COPY package*.json ./

# Install app dependencies
RUN npm install

# Copy the contents of the local src directory to /app
COPY . .

# Expose port 8080 to the outside world
EXPOSE 8081

# Define the command to run your app
CMD ["npm", "run", "serve"]
