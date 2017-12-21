pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'build start'
        sh '''./gradlew clean
./gradlew build'''
      }
    }
  }
}