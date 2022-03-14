pipeline {

  environment {
    registry = '694182744302.dkr.ecr.us-east-1.amazonaws.com/hello-world-aws'
    registryCredential = 'ad580ba8-bb18-4301-9e51-3f592cdc44a7'
    dockerhubCredentials = '04202415'
    dockerImage = 'hello-world-aws'
  }
    agent any
    triggers {
        pollSCM '* * * * *'
    }

    stages {


        stage('Build') {
            steps {
                echo "Building"
                bat 'gradlew build'
            }
        }

		stage ('Build docker image') {
    		steps {
    			echo "Docker step"
        		bat 'docker build --build-arg JAR_FILE=build/libs/rest-service-0.0.1-SNAPSHOT.jar -t hello-world-aws .'
    			}
		}

		 stage('Push Docker image') {
                    environment {
                        DOCKER_HUB_LOGIN = credentials('docker-hub')
                    }
                    steps {
                        bat 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                        bat './gradlew dockerPush -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR'
                    }
                }

//     	stage('Push Docker image to ECR') {
//             steps {
//                     echo "Pushing docker image to repository"
//                     script	{
//                         docker.withRegistry("https://" + registry, "ecr:us-east-1:" + registryCredential) {
//                         docker.image("hello-world-aws:latest").push()
//                      }
//                 }
//             }
//         }


    }


}
