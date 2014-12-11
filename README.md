Docker/Fig Example
==================

In order to run this you need to install a few things.

Boot2docker:
https://docs.docker.com/installation/mac/

Fig
```bash
curl -L https://github.com/docker/fig/releases/download/1.0.1/fig-`uname -s`-`uname -m` > /usr/local/bin/fig; chmod +x /usr/local/bin/fig
```

And maven.

Once the project is checked out, open boot2docker and cd into the project directory.

First you'll want to:
```
mvn package
```
to ensure the war is built.

Next run
```
fig up
```

If this is your first time running these commands, they will need to download a lot of things.
It will take a while, I recommed getting some coffee while you wait.

After the app and associated services start, you should be able to see the memcached info from this url (assuming you added a localdocker entry to your /etc/hosts, if you didn't your docker ip is most likely 192.168.59.103).

[http://localdocker:8080/docker-fig-example-1.0-SNAPSHOT/memcached](http://localdocker:8080/docker-fig-example-1.0-SNAPSHOT/memcached)

You can also set values in memcached with

http://localdocker:8080/docker-fig-example-1.0-SNAPSHOT/memcached/set/{key}/{value}

And retrive them

http://localdocker:8080/docker-fig-example-1.0-SNAPSHOT/memcached/get/{key}
