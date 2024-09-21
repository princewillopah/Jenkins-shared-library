#!/urs/bin/env groovy

def call(String name = 'Princewill') {
    echo "Building the Jar file for ${name}!"
    sh 'mvn package'
}
