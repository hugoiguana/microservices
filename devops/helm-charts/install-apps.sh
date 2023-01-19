#!/bin/bash

helm install db-ms-sales ./helm-charts/db-ms-sales --dry-run --debug
helm install db-ms-sales ./helm-charts/db-ms-sales
helm install nginx ./helm-charts/nginx