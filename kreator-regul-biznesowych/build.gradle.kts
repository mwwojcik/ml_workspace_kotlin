

allprojects{
    group="mw.kotlin"
    version="1.0"

    repositories {
        mavenCentral()
        maven {
            url = uri("https://maven.atlassian.com/content/repositories/atlassian-public")
        }

        maven {
            url = uri("http://krus-idm.hq.abg.com.pl:8081/artifactory/krus1")
        }
    }

   plugins{
       //wszystkie podprojekty dostają mozliwość includowania starterów
       //i korzystania ze springa
       //jest to gradlowy sposob realizacji mavenowskiego BOM i parent pom
       //to wystarczy o ile nie chcemy tworzyc jara i aplikacji
       id("io.spring.dependency-management") version "1.0.6.RELEASE"
   }




}

