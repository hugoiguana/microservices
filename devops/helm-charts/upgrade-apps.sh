#!/bin/bash

helm upgrade db-ms-sales ./helm-charts/db-ms-sales
helm upgrade ms-sales ./helm-charts/ms-sales