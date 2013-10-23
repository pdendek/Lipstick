/*
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
	excludes 'log4j', 'jcl-over-slf4j', /*'slf4j-api', 'slf4j-log4j12',*/ 'tomcat','jsp-api','commons-el','servlet-api','grails-plugin-log4j'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
	mavenRepo "https://repository.cloudera.com/artifactory/cloudera-repos/"
	
        // uncomment these to enable remote dependency resolution from public Maven repositories
        mavenCentral()
        mavenLocal()
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.16'
        runtime 'org.apache.hadoop:hadoop-core:2.0.0-mr1-cdh4.3.0'
        runtime 'org.apache.hadoop:hadoop-common:2.0.0-cdh4.3.0'
	runtime 'org.slf4j:slf4j-api:1.7.5'
	runtime 'org.slf4j:slf4j-log4j12:1.7.5'
        compile 'org.apache.pig:pig:0.11.0-cdh4.3.0'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        compile ":external-config:2.0"
        compile ":quartz:1.0-RC6"

        build ":tomcat:$grailsVersion"
    }
}
