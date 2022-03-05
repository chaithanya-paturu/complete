pipeline {
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
        		bat 'docker build --build-arg JAR_FILE=build/libs/rest-service-0.0.1-SNAPSHOT.jar -t nike/rest-service-docker .'
    }
}
    }
}
