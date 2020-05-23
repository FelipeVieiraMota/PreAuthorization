1) # Make a new Network
docker network create -d bridge custom

2) # Create builds
docker build -t preauthorization . 
docker build -t capture . 
docker build -t refund .


3) # Any problem with a Java variable wander, run these commands in the shell

cd .../PreAut..

# ****************************************************************
# Commands to build and run ( Execute it in the shell )
# ****************************************************************
   JAVA_HOME=$(dirname $( readlink -f $(which java) )) &&
   JAVA_HOME=$(realpath "$JAVA_HOME"/../) &&
   export JAVA_HOME &&
   mvn clean &&
   ./mvnw install &&
   docker build -t preauthorization-img . &&
   docker run -p 8888:8888 preauthorization
#*****************************************************************


cd .../Cap.....

# ****************************************************************
# Commands to build and run ( Execute it in the shell )
# ****************************************************************
    JAVA_HOME=$(dirname $( readlink -f $(which java) )) &&
    JAVA_HOME=$(realpath "$JAVA_HOME"/../) &&
    export JAVA_HOME &&
    mvn clean &&
    ./mvnw install &&
    docker build -t capture-img . &&
    docker run -p 8884:8884 capture
#*****************************************************************


cd .../Refund..

# ****************************************************************
# Commands to build and run ( Execute it in the shell )
# ****************************************************************
    clear && JAVA_HOME=$(dirname $( readlink -f $(which java) )) &&
    JAVA_HOME=$(realpath "$JAVA_HOME"/../) &&
    export JAVA_HOME &&
    mvn clean &&
    ./mvnw install &&
    docker build -t refun-img . &&
    docker run -p 8882:8882 refund
#*****************************************************************


4) API Links

A)  http://localhost:8888/preauthorization

Result ex: 
// 20200523020928
// http://localhost:8888/preauthorization

{
  "id": "8ac7a4a07231cbc001723fefa1054f23",
  "code": "000.100.110",
  "description": "Request successfully processed in 'Merchant in Integrator Test Mode'"
}


B)  http://localhost:8884/capture/{id}

Result ex:
// 20200523020932
// http://localhost:8884/capture/8ac7a4a07231cbc001723fce67cd45c5

{
  "id": "8ac7a4a07231cbc001723fefaeed4f2f",
  "code": "000.100.110",
  "description": "Request successfully processed in 'Merchant in Integrator Test Mode'"
}   


C)  http://localhost:8882/refund/{id}

Result ex:
// 20200523020935
// http://localhost:8882/refund/8ac7a4a17231c18401723fd2d11b4fa7

{
  "id": "8ac7a4a27231cbc001723fefbb095a7f",
  "code": "000.100.110",
  "description": "Request successfully processed in 'Merchant in Integrator Test Mode'"
}


5) # Docker shell

#kill all
docker system prune -a --volumes

#To delete all containers including its volumes use,
docker rm -vf $(docker ps -a -q)


#To delete all the images,
docker rmi -f $(docker images -a -q)

#####################################################
  docker logout
  docker login
  docker images | grep preauthorization
  docker network ls
  docker ps
  docker exec -it <container-name> /bin/sh
#####################################################


docker build -t preauthorization . 
docker tag preauthorization felipemotadocker/preauthorization:1.0.0
docker push felipemotadocker/preauthorization:1.0.0


docker build -t capture . 
docker tag capture felipemotadocker/capture:1.0.0
docker push felipemotadocker/capture:1.0.0

docker build -t refund .
docker tag refund felipemotadocker/refund:1.0.0
docker push felipemotadocker/refund:1.0.0