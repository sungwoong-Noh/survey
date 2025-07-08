pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sungwoong-Noh/survey.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
                // Gradle인 경우:
            }
        }
        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: false
                // Gradle인 경우:
            }
        }
    }
    post {
        success {
            echo 'Build completed successfully and JAR file archived.'
        }
        failure {
            echo 'Build failed.'
        }
    }
}