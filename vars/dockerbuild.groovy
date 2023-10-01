def call(String dockerfile = 'Dockerfile', 
         String buildContext = null,    
         String image_name = null, 
         String image_tag = null,
         String registryURL = null,
         String registryCredentials = null) {    
        echo "This is dockerBuild.groovy"
        def dockerImage = docker.build("${image_name}:${image_tag}", "-f ${dockerfile} ${buildContext}")
        docker.withRegistry("${registryURL}", "${registryCredentials}") {
            dockerImage.push()
        }    
        sh """
            docker images
            docker image prune -f 
            docker builder prune -af 
            docker rmi ${image_name}:${image_tag}
            docker images
        """                   
}
