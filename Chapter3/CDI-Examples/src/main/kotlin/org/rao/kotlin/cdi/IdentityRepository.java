package org.rao.kotlin.cdi;

import java.util.UUID;

public class IdentityRepository
{
    public void store(Person person) {
        person.setIdentifier(UUID.randomUUID());

    }
}
