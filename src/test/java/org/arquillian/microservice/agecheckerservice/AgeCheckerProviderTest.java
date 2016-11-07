package org.arquillian.microservice.agecheckerservice;

import org.arquillian.microservice.agecheckerservice.boundary.AgeCheckerResource;
import org.arquillian.microservice.agecheckerservice.controller.AgeChecker;
import org.arquillian.pact.provider.api.deployment.Environment;
import org.arquillian.pact.provider.core.httptarget.Target;
import org.arquillian.pact.provider.loader.git.PactGit;
import org.arquillian.pact.provider.spi.Provider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import java.net.URL;

@RunWith(Arquillian.class)
@Provider("age-checker")
@RunAsClient
@PactGit(value = "${giturl:http://localhost:3000/alex/gamer-contracts.git}", username = "${gitusername:alex}", password = "${gitpassword:alex}")
public class AgeCheckerProviderTest {

    @Deployment(testable = false)
    public static Archive createDeployment() {
        JAXRSArchive jaxrsArchive = ShrinkWrap.create(JAXRSArchive.class);
        jaxrsArchive.addResource(AgeChecker.class)
                .addResource(AgeCheckerResource.class);

        return jaxrsArchive;
    }

    @ArquillianResource
    URL webapp;

    @ArquillianResource
    @Environment("agechecker.url")
    Target target;

    @Test
    public void should_validate_contracts() {
        target.testInteraction(webapp);
    }

}
