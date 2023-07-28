
#!/bin/sh

mvn clean install -DskipTests

VERSION=$(git log -1 --pretty=%h)


if [ -z "$1" ]
  then
    echo "Native build\n"
    docker build -f Docker/Dockerfile -t jeremyqzt/ribbonnotif .
    exit 0
fi

echo "Buildx build\n"
eval "docker buildx build --push --platform=linux/arm64,linux/amd64 -f Docker/Dockerfile -t jeremyqzt/ribbonnotif:$VERSION ."


IMAGE="jeremyqzt/ribbonnotif:$VERSION" envsubst < k8s.yaml | kubectl apply -f -