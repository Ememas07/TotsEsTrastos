#!/bin/bash

#Directorio donde está este script
SCRIPT_DIR=$(dirname $0)
#Directorio del proyecto. Por comodidad
PROJECT_DIR=${SCRIPT_DIR}/../

docker-compose -f "${PROJECT_DIR}/docker/docker-compose-arm.yaml" --env-file="${PROJECT_DIR}/.env.local" --project-directory "${PROJECT_DIR}" down

#PHP (project) container
#Apache2 container
#docker exec -dt apache2_811 sh -c 'tail -f /var/log/apache2/project_access.log > /proc/1/fd/1'
#docker exec -dt apache2_811 sh -c 'tail -f /var/log/apache2/project_error.log > /proc/1/fd/2'