#!/urs/bin/env groovy

def call(String name = 'Princewill') {
    echo "Building the docker image for ${name}!"
    withCredentials([usernamePassword(credentialsId: 'my-credentials', usernameVariable: 'MY_DOCKER__USERNAME', passwordVariable: 'MY_DOCKER_PASSWORD')]) {
        // Here we use the USERNAME and PASSWORD variables in a git command
    //   sh """
    //      docker build -t princewillopah/nana-demo:version-1 .
    //      echo ${MY_DOCKER_PASSWORD} | docker login -u ${MY_DOCKER__USERNAME} --password-stdin
    //      docker push princewillopah/nana-demo:version-1
    //    """
    sh 'docker build -t princewillopah/nana-demo:version-1 .'
    sh 'echo "$MY_DOCKER_PASSWORD" | docker login -u "$MY_DOCKER__USERNAME" --password-stdin'   
    sh 'docker push princewillopah/nana-demo:version-1'
}

