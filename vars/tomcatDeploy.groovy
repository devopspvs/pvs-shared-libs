def call(creds,tomcatIp,userNmae,warName){
  sshagent([creds]){
   //copy war file to tomcat webapp folder
    sh "scp -v -o StrictHostKeyChecking=no target/${warname}.war ${userName}@${tomcatIp}:/opt/tomcat9/webapps"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }

}
