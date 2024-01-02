#!/bin/sh
echo "Building frontend..."
cd ../consumer/web/

docker build -t consumer:0.1 .