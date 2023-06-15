#!/bin/bash

# Change directory to the project's root
cd "$(git rev-parse --show-toplevel)"

# Check for updated dependencies and microservice versions
dependency_updates=$(mvn versions:display-property-updates versions:display-parent-updates -DgenerateBackupPoms=false \
    | grep '\->' \
    | awk -F ' ' '{if ($2 != $4) print $0}')

# Check if dependency updates are available
if [[ -n "$dependency_updates" ]]; then
    echo "WARNING: The following dependencies or microservices have updates available:"
        echo "$dependency_updates"
fi